package cleanplate.cleanplatehombres.Repositories;


import cleanplate.cleanplatehombres.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization getById(Integer id);


}