package syoux.wallets.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import syoux.wallets.domain.SessionDomain;
import syoux.wallets.model.UserSession;
import syoux.wallets.service.DefaultSessionService;

@Component
public class DefaultSessionComponent implements SessionComponent {
  private final SessionDomain sessionDomain;

  @Autowired
  public DefaultSessionComponent(final SessionDomain sessionDomain) {
    this.sessionDomain = sessionDomain;
  }

  @Override
  public void init(UserSession session) {
    this.sessionDomain.init(session);
  }
}
