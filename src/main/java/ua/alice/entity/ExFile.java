package ua.alice.entity;
import javax.persistence.*;
import java.io.File;
//TODO: заменить размер на числа
@Entity
@Table(name = "files")
public class ExFile {
    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

 /*   @Column(name = "file_file")
    private File file;*/

    @Column(name = "file_name")
    private String name;

    @Column(name = "size_file")
    private String size;

    @Column(name = "about_file")
    private String about;

     public ExFile(){ }

    public ExFile(String name, String size, String about) {
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

   /* public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
