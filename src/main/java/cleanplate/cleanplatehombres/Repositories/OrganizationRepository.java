package cleanplate.cleanplatehombres.Repositories;

import cleanplate.cleanplatehombres.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization getById(Integer id);
    List<Organization> getOrganizationByUser(User user);
    List<Organization> getOrganizationByUserId(Integer id);
//    Organization getOrganizationById(Integer id);
//    Organization getOrganizationAddress(String orgStAddress);
    List<Organization> getAllByOrgNameContaining(@Param("keyword") String orgName);

//    @Modifying
//    @Query("UPDATE org_info AS o " +
//            "set o.id = id, " +
//            "o.images = images, " +
//            "o.is_donor = isDonor, " +
//            "o.org_city = orgCity, " +
//            "o.org_description = orgDescription, " +
//            "o.org_name = orgName, " +
//            "o.org_st_address = orgStAddress, " +
//            "o.org_state = orgState, " +
//            "o.org_zip = orgZip, " +
//            "o.user_id = user " +
//            "where o.id = id")
//    Integer updateOrg(
//            @Param("id") Integer id
//    );

}