package ua.alice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alice.entity.*;
import ua.alice.repository.DepartmentJpaRepository;
import ua.alice.repository.ExFileJpaRepository;
import ua.alice.repository.SubdivisionJpaRepository;
import ua.alice.repository.UserJpaRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

/**
 * Created by Лис on 26.05.2016.
 */
@Component
public class BootStrap {
    @Autowired
    private ExFileJpaRepository exFileJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private SubdivisionJpaRepository subdivisionJpaRepository;

    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;


    @PostConstruct
    public void init() {

        System.err.println("iniiiiiiiiiiiiiiiiiiiit");

        ExFile exFile1 = new ExFile("firstFile","sdfdf", "ololo");
     //   ExFile exFile2 = new ExFile("secondFile", new File("SecondFile"));

     //   exFile1.setFile(new File("FirstFile"));

        Department department1 = new Department("Finance");
        Department department2 = new Department("Law");

        Subdivision subdivision1 = new Subdivision("Right");
        Subdivision subdivision2 = new Subdivision("Left");

        departmentJpaRepository.save(department1);
        departmentJpaRepository.save(department2);

        subdivisionJpaRepository.save(subdivision1);
        subdivisionJpaRepository.save(subdivision2);

        exFileJpaRepository.save(exFile1);
  //      exFileJpaRepository.save(exFile2);
        User user = new User("admin", "1111111", "firstAdmin", Role.ADMIN, "surname", "patronymic", "somemail@gmail.com", "123456789");
        department1.setUser(user);
        subdivision1.setUser(user);

        user.setDepartment(department1);
        user.setSubdivision(subdivision1);

        userJpaRepository.save(user);
    }
}
