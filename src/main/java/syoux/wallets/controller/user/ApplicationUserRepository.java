package syoux.wallets.controller.user;

import org.springframework.data.jpa.repository.JpaRepository;
import syoux.wallets.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
  ApplicationUser findByUsername(String username);
}
