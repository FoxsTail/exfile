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

    @ManyToOne
    @JoinColumn(name = "file_id")
    private ExFile exFile;


    Subdivision(){ }

    public Subdivision(String name, List<User> users) {
        this.name = name;
        this.users = users;

    }

    public Subdivision(String name) {
        this.name = name;
    }

    public void addUser(User user){
        user.setSubdivision(this);
        users.add(user);
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

    public ExFile getExFile() {
        return exFile;
    }

    public void setExFile(ExFile exFile) {
        this.exFile = exFile;
    }
}
