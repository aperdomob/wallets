package syoux.wallets.component;

import syoux.wallets.model.UserWallet;
import syoux.wallets.model.UserSession;

public interface SessionComponent {
  void init(UserSession session);
  UserWallet loadUser(String username) throws Exception;
}
