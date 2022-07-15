package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String userName;

    @Column
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private Boolean isAdmin;

    @OneToMany
    private List<Organization> organizationList;

    public User() {}

    public User(Integer id, String userName, String userEmail, String userPassword, Boolean isAdmin) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isAdmin = isAdmin;
    }

    public User(User user) {
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}