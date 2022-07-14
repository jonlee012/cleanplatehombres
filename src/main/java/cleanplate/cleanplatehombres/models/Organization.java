package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orgInfo")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String orgName;

    @Column
    private String orgDescription;

    @Column
    private String orgStAddress;

    @Column
    private String orgCity;

    @Column
    private String orgState;

    @Column
    private long orgZip;

    @Column
    private boolean isDonor;

    @ManyToOne
    @JoinColumn(name="userInfo", nullable = false)
    private User user;

    @OneToMany
    private List<Listing> listingList;

    public Organization() {
    }

    public Organization(String orgName, String orgDescription, String orgStAddress, String orgCity, String orgState, long orgZip, boolean isDonor, User user) {
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.orgStAddress = orgStAddress;
        this.orgCity = orgCity;
        this.orgState = orgState;
        this.orgZip = orgZip;
        this.isDonor = isDonor;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgStAddress() {
        return orgStAddress;
    }

    public void setOrgStAddress(String orgStAddress) {
        this.orgStAddress = orgStAddress;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgState() {
        return orgState;
    }

    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    public long getOrgZip() {
        return orgZip;
    }

    public void setOrgZip(long orgZip) {
        this.orgZip = orgZip;
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