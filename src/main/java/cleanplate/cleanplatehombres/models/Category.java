package cleanplate.cleanplatehombres.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryId;

    @Column
    private String categoryName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private List<Listing> listingList;

    public Category(){}

    public Category(String categoryName, List<Listing> listingList) {
        this.categoryName = categoryName;
        this.listingList = listingList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Listing> getListingList() {
        return listingList;
    }

    public void setListingList(List<Listing> listingList) {
        this.listingList = listingList;
    }
};