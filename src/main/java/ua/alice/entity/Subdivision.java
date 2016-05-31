package ua.alice.entity;

import javax.persistence.*;
import java.lang.Integer;import java.lang.String;

@Entity
@Table(name = "subdivisions")
public class Subdivision {
    @Id
    @GeneratedValue
    @Column(name = "id_subdivision")
    private Integer id;

    @Column(name = "name_subdivision", length = 60)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "subdivision", cascade = CascadeType.ALL)
    private User user;



    Subdivision(){ }

    public Subdivision(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Subdivision(String name) {
        this.name = name;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
