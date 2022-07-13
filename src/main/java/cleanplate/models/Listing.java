package cleanplate.models;

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
        private String food_name;

        @Column
        private String food_amt;

        @Column
        private String donation_description;

        @Column
        private boolean isDonation;

        @Column
        private Date exp_date;

        @Column
        private boolean isFulfilled;

        @Column
        private boolean isDonor;

        public Listing(Long id, String food_name, String food_amt, String donation_description, boolean isDonation, Date exp_date, boolean isFulfilled, boolean isDonor) {
            this.id = id;
            this.food_name = food_name;
            this.food_amt = food_amt;
            this.donation_description = donation_description;
            this.isDonation = isDonation;
            this.exp_date = exp_date;
            this.isFulfilled = isFulfilled;
            this.isDonor = isDonor;
        }



//        @ManyToOne
//        @JoinColumn(name = "user_info", nullable = false)
//        private User user;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Listing(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_amt() {
        return food_amt;
    }

    public void setFood_amt(String food_amt) {
        this.food_amt = food_amt;
    }

    public String getDonation_description() {
        return donation_description;
    }

    public void setDonation_description(String donation_description) {
        this.donation_description = donation_description;
    }

    public boolean isDonation() {
        return isDonation;
    }

    public void setDonation(boolean donation) {
        isDonation = donation;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
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





