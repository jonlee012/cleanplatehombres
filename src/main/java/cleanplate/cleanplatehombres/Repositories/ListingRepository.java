package cleanplate.cleanplatehombres.Repositories;


import cleanplate.cleanplatehombres.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    Listing getById(Integer id);

//    List<Listing> getByUser(User user);

}