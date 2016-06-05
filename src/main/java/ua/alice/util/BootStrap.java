package ua.alice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alice.entity.*;
import ua.alice.repository.*;

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
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;


    @PostConstruct
    public void init() {

        System.err.println("iniiiiiiiiiiiiiiiiiiiit");

        Department department1 = new Department("Finance");
        Department department2 = new Department("Law");
        Department department3 = new Department("Minister");

        Subdivision subdivision1 = new Subdivision("Right");
        Subdivision subdivision2 = new Subdivision("Left");

        Category category1 = new Category("firstOne");
        Category category2 = new Category("secondOne");
        Category category3 = new Category("thirdOne");

        categoryJpaRepository.save(category1);
        categoryJpaRepository.save(category2);
        categoryJpaRepository.save(category3);

        departmentJpaRepository.save(department1);
        departmentJpaRepository.save(department2);
        departmentJpaRepository.save(department3);

        subdivisionJpaRepository.save(subdivision1);
        subdivisionJpaRepository.save(subdivision2);

        subdivision1.addDepartment(department1, department2, department3);
        subdivision2.addDepartment(department1, department2);


        User user = new User("Admin", "1111111", "Firstadmin", Role.ADMIN, "Surname", "Patronymic", "somemail@gmail.com", "45678912378");
        department1.addUser(user);
        subdivision1.addUser(user);


        user.setDepartment(department1);
        user.setSubdivision(subdivision1);

        userJpaRepository.save(user);
    }
}
