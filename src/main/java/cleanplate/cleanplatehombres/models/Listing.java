package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.Date;


//table creation
    @Entity
    @Table(name = "listing")
    public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String foodName;

    @Column
    private String foodAmt;

    @Column
    private String donationDescription;

    @Column
    private boolean isDonation;

    @Column
    private Date expDate;

    @Column
    private boolean isFulfilled;

    @Column
    private boolean isDonor;

    public Listing(Long id, String foodName, String foodAmt, String donationDescription, boolean isDonation, Date expDate, boolean isFulfilled, boolean isDonor) {
        this.id = id;
        this.foodName = foodName;
        this.foodAmt = foodAmt;
        this.donationDescription = donationDescription;
        this.isDonation = isDonation;
        this.expDate = expDate;
        this.isFulfilled = isFulfilled;
        this.isDonor = isDonor;
    }

    //        @ManyToOne
//        @JoinColumn(name = "user_info", nullable = false)
//        private User user;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Listing() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public boolean isDonor() {
        return isDonor;
    }

    public void setDonor(boolean donor) {
        isDonor = donor;
    }
}




