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
import ua.alice.entity.ExFile;
import ua.alice.entity.User;
import ua.alice.repository.ExFileJpaRepository;
import ua.alice.repository.UserJpaRepository;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/web")
public class MainController {
    @Autowired
    private ExFileJpaRepository exFileJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

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
            return new ModelAndView("sendFile");
        }
     //   exFile.setFile(new File("WeARE"));

        exFileJpaRepository.save(exFile);

        return new ModelAndView("sendFile");
    }

    @RequestMapping("/send")
    public ModelAndView sendPage(){

        User userLogin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userJpaRepository.findUserByLogin(userLogin.getLogin());

        return new ModelAndView("sendFile", "file", new ExFile());
    }

}