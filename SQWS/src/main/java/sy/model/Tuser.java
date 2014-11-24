package sy.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by shui on 2014/11/15.
 */

@Entity
@Table(name = "T_USER",schema = "")
public class Tuser implements java.io.Serializable {

    private String id;

    private String name;

    private String pwd;

    private Date createdatetime;

    private Date updatedatetime;

    private String sex;

    private Integer age;

    private String photo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDATETIME",length = 7)
    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATEDATETIME",length = 7)
    public Date getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(Date updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    @Column(name = "SEX", length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "AGE", precision = 8, scale = 0)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    @Column(name = "PHOTO", length = 100)
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password", length = 50)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
