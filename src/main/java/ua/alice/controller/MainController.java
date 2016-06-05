package ua.alice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.alice.entity.*;
import ua.alice.repository.*;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/web")
public class MainController {

    public static final String SAVE_LOCATION = "D:\\work\\workin\\4й курс\\диплом\\exfile\\src\\main\\webapp\\resources\\document\\";

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
    public ModelAndView files() {
        List<ExFile> files = exFileJpaRepository.findAll();
        return new ModelAndView("files", "files", files);
    }

    @RequestMapping("/users")
    public ModelAndView users() {
        Sort sort = new Sort("lastName", "firstName", "patronymic");
        List<User> users = userJpaRepository.findAll();
        return new ModelAndView("users", "users", users);
    }

    @RequestMapping("/users/{id}")
    public ModelAndView student(@PathVariable("id") Long id) {
        User user = userJpaRepository.findOne(id);
        return new ModelAndView("user", "user", user);
    }

    @RequestMapping("/download")
    public  ModelAndView uploadFile(){
        List<ExFile> files = exFileJpaRepository.findAll();
        return new ModelAndView("download", "files", files);
    }





    @RequestMapping(value = "/sendF", method = RequestMethod.POST)
    public ModelAndView sendF(@Valid @ModelAttribute("uploadForm") ExFile exFile,  BindingResult bindingResult) {

     if (bindingResult.hasErrors()) {
            return new ModelAndView("sendF");
        }

       MultipartFile file = exFile.getMultipartFilefile();

        if (file.getOriginalFilename().contains("/")) {
            return new ModelAndView( "someErrors");
        }
        if (file.getOriginalFilename().contains("/")) {
            return new ModelAndView("someErrors");
        }


        if (!file.isEmpty()) {
//---------------//
            exFile.setName(file.getOriginalFilename());
            String name = file.getOriginalFilename();
            exFile.setSize(file.getSize());
            String location = SAVE_LOCATION;
            File pathFile = new File(location);
            if (!pathFile.exists()) {
                pathFile.mkdir();
            }
            pathFile = new File(location + file.getOriginalFilename());
            try {
                file.transferTo(pathFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            exFile.setPath(location + file.getOriginalFilename());

            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            exFile.setDate(format1.format(new Date()));

//-----------//
            Category category;
            for (String s : exFile.getValue_categories()) {
                category = categoryJpaRepository.findOne(Integer.parseInt(s));
                exFile.addGetterCategory(category);
            }

            Department department;
            for (String s : exFile.getValue_departments()) {
                department = departmentJpaRepository.findOne(Integer.parseInt(s));
                exFile.addGetterDepartment(department);
            }

            Subdivision subdivision;
            for (String s : exFile.getValue_subdivisions()) {
                subdivision = subdivisionJpaRepository.findOne(Integer.parseInt(s));
                exFile.addGetterSubdivision(subdivision);
            }

//------финт ушами----//
            User user = getCurrentUser();
            exFile.setUser(user);
//----//
            Department dep1 = departmentJpaRepository.findOne(exFile.getUser().getDepartment().getIdd());
            Subdivision sub1 = subdivisionJpaRepository.findOne(exFile.getUser().getSubdivision().getIds());

            exFile.setSender_subdivision(sub1);
            exFile.setSender_department(dep1);

            exFileJpaRepository.save(exFile);

            System.err.println(exFile.getSender_department().getName()+ "--------------");
            return new ModelAndView("okpage", "files", exFile);

        } else {
            return new ModelAndView("someErrors", "message", "You forgot to add the file, want to come back and try again?");
        }


    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ModelAndView provideUploadInfo() {

        User user =  getCurrentUser();
        user.addExFile(new ExFile());

        ModelAndView modelAndView = new ModelAndView("sendF");
        List<Subdivision> subdivisions = subdivisionJpaRepository.findAll();
        Map<Integer, String> subMap = new HashMap<>();
        for (Subdivision s : subdivisions) {
            subMap.put(s.getIds(), s.getName());
        }

        List<Department> departments = departmentJpaRepository.findAll();
        Map<Integer, String> depMap = new HashMap<>();
        for (Department d : departments) {
            depMap.put(d.getIdd(), d.getName());
        }

        List<Category> categories = categoryJpaRepository.findAll();
        Map<Integer, String> catMap = new HashMap<>();
        for(Category c: categories){
            catMap.put(c.getIdc(), c.getName());
        }

        modelAndView.addObject("sub", subMap);
        modelAndView.addObject("dep", depMap);
        modelAndView.addObject("cat", catMap);
        modelAndView.addObject("uploadForm", user.getLastAddedFile());

        return modelAndView;

    }

    public User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userJpaRepository.findUserByLogin(user.getLogin());

        return user;
    }
}
