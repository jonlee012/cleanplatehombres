package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

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

    public User(User copy) {
        userId = copy.userId; // This line is SUPER important! Many things won't work if it's absent
        userEmail = copy.userEmail;
        userName = copy.userName;
        Password = copy.Password;
    }



    public User(String userName, String userEmail, String userPassword, Boolean isAdmin) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isAdmin = isAdmin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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