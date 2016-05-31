package ua.alice.entity;

/**
 * Created by Лис on 26.05.2016.
 */

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

  /*  @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z][a-z]+")*/
    @Column(name = "login_user", unique = true)
    private String login;

/*    @Size(min = 6, max = 20)*/
    @Column(name = "password_user")
    private String password;

   /* @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z][a-z]+")*/
    @Column(name = "name_user")
    private String name;

    @Column(name = "role_user")
    private Role role;
/*
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z][a-z]+")*/
    @Column(name = "surname_user")
    private String surname;

/*    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z][a-z]+")*/
    @Column(name = "patronymic_user")
    private String patronymic;

    @Column(name = "email_user", unique = true)
    private String email;

    @Column(name = "inn_user")
    private String inn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subdivision")
    private Subdivision subdivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department")
    private Department department;

    @Column(name = "block_status")
    private Boolean blocked_Y_N = false;

    @Transient
    private String department_trans;

    @Transient
    private String subdivision_trans;

    public User() {
    }

  /*  public User(String login, String password, String name, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }
*/

    public User(String login, String password, String name, Role role, String surname, String patronymic, String email, String inn) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.inn = inn;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getDepartment_trans() {
        return department_trans;
    }

    public void setDepartment_trans(String department_trans) {
        this.department_trans = department_trans;
    }

    public String getSubdivision_trans() {
        return subdivision_trans;
    }

    public void setSubdivision_trans(String subdivision_trans) {
        this.subdivision_trans = subdivision_trans;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getInn() {
        return inn;
    }

    public Long getId() {
        return id;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public Department getDepartment() {
        return department;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getBlocked_Y_N() {
        return blocked_Y_N;
    }

    public void setBlocked_Y_N(Boolean blocked_Y_N) {
        this.blocked_Y_N = blocked_Y_N;
    }
}