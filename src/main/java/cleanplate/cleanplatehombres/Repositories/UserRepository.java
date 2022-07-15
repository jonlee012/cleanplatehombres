package cleanplate.cleanplatehombres.Repositories;

import cleanplate.cleanplatehombres.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}