package ua.alice.entity;

import javax.persistence.*;
import java.io.File;

//TODO: заменить ручные закидки на подгрузку информации файла
//TODO: скорректировать подгрузку документа в отделы и дэп, прочекать конструкторы
@Entity
@Table(name = "files")
public class ExFile {
    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @Column(name = "file_file")
    private File file;

    @Column(name = "file_name")
    private String name;

    @Column(name = "size_file")
    private Integer size;

    @Column(name = "about_file")
    private String about;

    @ManyToOne
    @JoinColumn(name = "id_subdivision")
    private Subdivision sender_subdivision;

    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department sender_department;

    @Transient
    private String sender_department_trans;

    @Transient
    private String sender_subdivision_trans;

    public ExFile() {
    }

    public ExFile(String name, Integer size, String about) {
        this.name = name;
        this.size = size;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Subdivision getSender_subdivision() {
        return sender_subdivision;
    }

    public void setSender_subdivision(Subdivision sender_subdivision) {
        this.sender_subdivision = sender_subdivision;
    }

    public Department getSender_department() {
        return sender_department;
    }

    public void setSender_department(Department sender_department) {
        this.sender_department = sender_department;
    }

    public String getSender_department_trans() {
        return sender_department_trans;
    }

    public void setSender_department_trans(String sender_department_trans) {
        this.sender_department_trans = sender_department_trans;
    }

    public String getSender_subdivision_trans() {
        return sender_subdivision_trans;
    }

    public void setSender_subdivision_trans(String sender_subdivision_trans) {
        this.sender_subdivision_trans = sender_subdivision_trans;
    }
}
