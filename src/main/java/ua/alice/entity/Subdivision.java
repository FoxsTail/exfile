package ua.alice.entity;

import javax.persistence.*;
import java.lang.Integer;import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subdivisions")
public class Subdivision {
    @Id
    @GeneratedValue
    @Column(name = "id_subdivision")
    private Integer ids;

    @Column(name = "name_subdivision", length = 60)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subdivision", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @ManyToMany( fetch = FetchType.EAGER, mappedBy = "getter_subdivisions", cascade = CascadeType.ALL)
    private List<ExFile> exFiles = new ArrayList<>();



    Subdivision(){ }

    public Subdivision(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Subdivision(String name) {
        this.name = name;
    }

//------methods
    public void addUser(User user){
        user.setSubdivision(this);
        users.add(user);
    }

    public void addFile(ExFile exFile){
        exFiles.add(exFile);
    }

 //----------------getters and setters


    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<ExFile> getExFiles() {
        return exFiles;
    }

    public void setExFiles(List<ExFile> exFiles) {
        this.exFiles = exFiles;
    }
}
