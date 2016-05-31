package ua.alice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id_department")
    private Integer id;

    @Column(name = "name_department", length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender_department", cascade = CascadeType.ALL)
    private List<ExFile> exFiles = new ArrayList<>();


    public Department(){ }

    public Department(String name, List<User> users, List<ExFile> exFiles) {
        this.name = name;
        this.users = users;
        this.exFiles = exFiles;
    }

    public Department(String name) {
        this.name = name;
    }

    public void addUser(User user){
        user.setDepartment(this);
        users.add(user);
    }

    public void addExFile(ExFile exFile){
        exFile.setSender_department(this);
        exFiles.add(exFile);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ExFile> getExFiles() {
        return exFiles;
    }

    public void setExFiles(List<ExFile> exFiles) {
        this.exFiles = exFiles;
    }
}
