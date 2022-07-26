package cleanplate.cleanplatehombres.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.List;

//table creation
@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String foodName;

    @Column
    private String foodAmt;

    @Column
    private String donationDescription;

    @Column
    private boolean isDonation;

    @Column
    private String expDate;

    @Column
    private boolean isFulfilled;

    @ManyToOne
    @JoinColumn(name = "ad_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="ad_org_id", nullable = false)
    private Organization organization;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="listing_categories",
            joinColumns={@JoinColumn(name="listing_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    public Listing() {}

    public Listing(Organization organization) {
        this.organization = organization;
    }

    public Listing(String foodName, String foodAmt, String donationDescription, boolean isDonation, String expDate,
                   boolean isFulfilled, User user, Organization organization, List<Category> categories) {
        this.foodName = foodName;
        this.foodAmt = foodAmt;
        this.donationDescription = donationDescription;
        this.isDonation = isDonation;
        this.expDate = expDate;
        this.isFulfilled = isFulfilled;
        this.user = user;
        this.organization = organization;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodAmt() {
        return foodAmt;
    }

    public void setFoodAmt(String foodAmt) {
        this.foodAmt = foodAmt;
    }

    public String getDonationDescription() {
        return donationDescription;
    }

    public void setDonationDescription(String donationDescription) {
        this.donationDescription = donationDescription;
    }

    public boolean isDonation() {
        return isDonation;
    }

    public void setDonation(boolean donation) {
        isDonation = donation;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}









