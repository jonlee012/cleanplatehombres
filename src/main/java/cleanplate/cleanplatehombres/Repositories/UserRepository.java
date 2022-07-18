package cleanplate.cleanplatehombres.Repositories;

import cleanplate.cleanplatehombres.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository <User, Integer> {
    User getUserByUserId(Integer id);
    User findByUserName(String username);
}
