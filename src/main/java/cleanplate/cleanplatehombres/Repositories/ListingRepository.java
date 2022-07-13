package cleanplate.cleanplatehombres.Repositories;


import cleanplate.cleanplatehombres.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    Listing getById(long id);

//    List<Listing> getByUser(User user);

}