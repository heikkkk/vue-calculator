package ntnu.idatt2105.henritsa.webcalculator.user.repository;

import java.util.Optional;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByName(String username);
}
