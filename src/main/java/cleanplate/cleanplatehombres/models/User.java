package cleanplate.models;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

//    @OneToMany
//    private List<Post> blogPost;

    public User() {}

    public User(User copy) { //this is called a Copy Constructor
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        isAdmin = copy.isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}