package cleanplate.cleanplatehombres.Repositories;


import cleanplate.cleanplatehombres.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    Listing getById(Integer id);
    void deleteById(Integer id);

    List<Listing> findAllByOrganizationId(Integer id);
    //    List<Listing> getByUser(User user);

}