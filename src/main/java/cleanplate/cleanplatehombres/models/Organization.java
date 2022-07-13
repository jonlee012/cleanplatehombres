package cleanplate.cleanplatehombres.models;

import javax.persistence.*;

@Entity
@Table(name = "org_info")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String org_name;

    @Column
    private String org_description;

    @Column
    private String org_st_address;

    @Column
    private String org_city;

    @Column
    private String org_state;

    @Column
    private long org_zip;

    @Column
    private boolean isDonor;

    @ManyToOne
    @JoinColumn(name="user_info", nullable = false)
    private User user;

    public Organization() {
    }

    public Organization(String org_name, String org_description, String org_st_address, String org_city, String org_state, long org_zip, boolean isDonor, User user) {
        this.org_name = org_name;
        this.org_description = org_description;
        this.org_st_address = org_st_address;
        this.org_city = org_city;
        this.org_state = org_state;
        this.org_zip = org_zip;
        this.isDonor = isDonor;
        this.user = user;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_description() {
        return org_description;
    }

    public void setOrg_description(String org_description) {
        this.org_description = org_description;
    }

    public String getOrg_st_address() {
        return org_st_address;
    }

    public void setOrg_st_address(String org_st_address) {
        this.org_st_address = org_st_address;
    }

    public String getOrg_city() {
        return org_city;
    }

    public void setOrg_city(String org_city) {
        this.org_city = org_city;
    }

    public String getOrg_state() {
        return org_state;
    }

    public void setOrg_state(String org_state) {
        this.org_state = org_state;
    }

    public long getOrg_zip() {
        return org_zip;
    }

    public void setOrg_zip(long org_zip) {
        this.org_zip = org_zip;
    }

    public boolean isDonor() {
        return isDonor;
    }

    public void setDonor(boolean donor) {
        isDonor = donor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}