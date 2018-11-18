package syoux.wallets.controller.dto;

import syoux.wallets.controller.dto.body.UserSessionBody;
import syoux.wallets.model.UserSession;

public class UserSessionTransformer {
  public static UserSession toModel(UserSessionBody body) {
    UserSession userSession = new UserSession();

    userSession.setSessionId(body.getSessionId());
    userSession.setMail(body.getMail());

    return userSession;
  }
}
