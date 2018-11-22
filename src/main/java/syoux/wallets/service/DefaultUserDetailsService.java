package syoux.wallets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import syoux.wallets.component.SessionComponent;
import syoux.wallets.model.UserWallet;

import static java.util.Collections.emptyList;

@Service
public class DefaultUserDetailsService implements UserDetailsService {
  private final SessionComponent sessionComponent;

  @Autowired
  public DefaultUserDetailsService(final SessionComponent sessionComponent) {
    this.sessionComponent = sessionComponent;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      UserWallet user = this.sessionComponent.loadUser(username);

      if (user == null) {
        throw new UsernameNotFoundException(username);
      }

      return new User(user.getUsername(), user.getPassword(), emptyList());
    } catch (Exception e) {
      throw new UsernameNotFoundException(e.getMessage());
    }

  }
}
