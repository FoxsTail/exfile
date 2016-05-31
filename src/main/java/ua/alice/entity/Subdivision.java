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
    private Integer id;

    @Column(name = "name_subdivision", length = 60)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subdivision", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender_subdivision", cascade = CascadeType.ALL)
    private List<ExFile> exFiles = new ArrayList<>();

    Subdivision(){ }

    public Subdivision(String name, List<User> users, List<ExFile> exFiles) {
        this.name = name;
        this.users = users;
        this.exFiles = exFiles;
    }

    public Subdivision(String name) {
        this.name = name;
    }

    public void addUser(User user){
        user.setSubdivision(this);
        users.add(user);
    }

    public void addExFile(ExFile exFile){
        exFile.setSender_subdivision(this);
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
