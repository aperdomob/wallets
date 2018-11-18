package syoux.wallets.component;

import org.springframework.stereotype.Component;
import syoux.wallets.model.UserSession;

@Component
public class DefaultSessionComponent implements SessionComponent {
  @Override
  public void init(UserSession session) {

  }
}
