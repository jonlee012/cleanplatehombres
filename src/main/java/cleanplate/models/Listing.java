package cleanplate.models;

import javax.persistence.*;



@Entity
@Table(name = "listings")
public class Listing{

    //table creation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(nullable = false, length = 255)
    public String title;

    @Column(nullable = false, length = 255)
    public String body;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Listing(){

    }

    public Listing(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}





