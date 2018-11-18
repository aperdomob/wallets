package syoux.wallets.service;

import org.springframework.stereotype.Service;
import syoux.wallets.model.UserSession;

@Service
public class DefaultSessionService implements SessionService {

  @Override
  public void init(UserSession session) {

  }
}
