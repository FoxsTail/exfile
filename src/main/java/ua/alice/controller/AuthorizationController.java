package ua.alice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.alice.entity.*;
import ua.alice.repository.DepartmentJpaRepository;
import ua.alice.repository.SubdivisionJpaRepository;
import ua.alice.repository.UserJpaRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Лис on 26.05.2016.
 */
@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;
    @Autowired
    private SubdivisionJpaRepository subdivisionJpaRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/registration");
        }
        Department department = departmentJpaRepository.findOne(Integer.parseInt(user.getDepartment_trans()));
        Subdivision subdivision = subdivisionJpaRepository.findOne(Integer.parseInt(user.getSubdivision_trans()));

        department.addUser(user);
        subdivision.addUser(user);

        user.setDepartment(department);
        user.setSubdivision(subdivision);

        user.setRole(Role.USER);
        userJpaRepository.save(user);

        return new ModelAndView("userSuccess", "user", user);
        //return new ModelAndView("redirect:/web/files");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");

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

        modelAndView.addObject("sub", subMap);
        modelAndView.addObject("dep", depMap);

        modelAndView.addObject("user", new User());
        return modelAndView;
    }


}
