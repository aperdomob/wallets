package syoux.wallets.service;

import syoux.wallets.model.UserWallet;
import syoux.wallets.model.UserSession;

public interface SessionService {
  void init(UserSession session);
}
