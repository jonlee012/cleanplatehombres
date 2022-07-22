//package cleanplate.cleanplatehombres.models;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name= "org_images")
//public class OrganizationImage {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false, length = 200)
//    private String images;
//
//    @OneToOne
//    @JoinColumn(name= "org_info")
//    private Organization organization;
//
//    public OrganizationImage(){
//
//    }
//
//    public OrganizationImage(Integer id, String images, Organization organization) {
//        this.id = id;
//        this.images = images;
//        this.organization = organization;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getImages() {
//        return images;
//    }
//
//    public void setImages(String images) {
//        this.images = images;
//    }
//
//    public Organization getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(Organization organization) {
//        this.organization = organization;
//    }
//}
//
