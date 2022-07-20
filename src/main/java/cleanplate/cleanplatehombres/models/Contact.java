package cleanplate.cleanplatehombres.models;

public class Contact {
    private String subject;
    private String body;
    private User name;


    public Contact() {

    }

    public Contact(String subject, String body, User name) {
        this.subject = subject;
        this.body = body;
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }
}