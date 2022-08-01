package cleanplate.cleanplatehombres.Repositories;

import cleanplate.cleanplatehombres.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User getById(Integer id);
    void deleteUserById(Integer id);
}

