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
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

    @OneToMany
    private List<Organization> organizationList;

    public User() {}


//    public User(User copy) {
//        userId = copy.userId; // This line is SUPER important! Many things won't work if it's absent
//        userEmail = copy.userEmail;
//        userName = copy.userName;
//        Password = copy.Password;
//    }



    public User(String userName, String userEmail, String userPassword, Boolean isAdmin) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isAdmin = isAdmin;

//    public User(String userName, String userEmail, String userPassword) {
//        this.userName = userName;
//        this.userEmail = userEmail;
//        this.userPassword = userPassword;
//        this.isAdmin = false;
//    }

    public User(User copy) {
        id = copy.id;
        isAdmin = copy.isAdmin;
        email = copy.email;
        username = copy.username;
        password = copy.password;

    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        this.id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}