package syoux.wallets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.wallets.component.SessionComponent;
import syoux.wallets.model.UserWallet;
import syoux.wallets.model.UserSession;

@Service
public class DefaultSessionService implements SessionService {
  private final SessionComponent sessionComponent;

  @Autowired
  DefaultSessionService(final SessionComponent sessionComponent) {
    this.sessionComponent = sessionComponent;
  }

  @Override
  public void init(UserSession session) {
    this.sessionComponent.init(session);
  }
}
