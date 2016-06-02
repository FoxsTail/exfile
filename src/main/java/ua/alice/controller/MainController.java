package ua.alice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.alice.entity.*;
import ua.alice.repository.*;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/web")
public class MainController {
    @Autowired
    private ExFileJpaRepository exFileJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;
    @Autowired
    private SubdivisionJpaRepository subdivisionJpaRepository;
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @RequestMapping("/files")
    public ModelAndView files(){
        List<ExFile> files = exFileJpaRepository.findAll();
        return new ModelAndView("files","files",files);
    }

    @RequestMapping("/users")
    public ModelAndView users(){
        List<User> users = userJpaRepository.findAll();

        System.err.println("--------------------");
        for (User user : users){
            System.err.println("---------------------------" + user.getLogin());
        }
        //на страничку такую-то, с таким-то параметром, такие-то данные
        return new ModelAndView("users", "users", users);
    }

    @RequestMapping(value = "/sendfile", method = RequestMethod.POST)
    public ModelAndView sendFile(@ModelAttribute("file") ExFile exFile, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ModelAndView("someErrors");
        }

        Category category;
        for(String s: exFile.getValue_categories()){
            category = categoryJpaRepository.findOne(Integer.parseInt(s));
            exFile.addGetterCategory(category);
        }

        Department department;
        for(String s: exFile.getValue_departments()){
            department = departmentJpaRepository.findOne(Integer.parseInt(s));
            exFile.addGetterDepartment(department);
        }

        Subdivision subdivision;
        for(String s: exFile.getValue_subdivisions()){
            subdivision = subdivisionJpaRepository.findOne(Integer.parseInt(s));
            exFile.addGetterSubdivision(subdivision);
        }

         Department dep1 = departmentJpaRepository.findOne(Integer.parseInt(exFile.getSender_department_trans()));
        Subdivision sub1 = subdivisionJpaRepository.findOne(Integer.parseInt(exFile.getSender_subdivision_trans()));


        exFile.setSender_subdivision(sub1);
        exFile.setSender_department(dep1);

        exFile.setFile(new File("WeARE"));

        exFileJpaRepository.save(exFile);

        return new ModelAndView("okpage");
    }

    @RequestMapping("/send")
    public ModelAndView sendPage(){

        User userLogin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userJpaRepository.findUserByLogin(userLogin.getLogin());

        return new ModelAndView("sendFile", "file", new ExFile());
    }

}
