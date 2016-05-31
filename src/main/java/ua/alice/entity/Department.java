package ua.alice.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id_department")
    private Integer id;

    @Column(name = "name_department", length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    private User user;

    public Department(){ }

    public Department(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Department(String name) {
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
