package syoux.wallets.repository.mapper;

import syoux.wallets.model.UserSession;
import syoux.wallets.repository.dao.UserSessionDao;

public class UserSessionMapper {
  public static UserSessionDao toDao(UserSession userSession) {
    UserSessionDao dao = new UserSessionDao();
    dao.setSessionId(userSession.getSessionId());
    dao.setMail(userSession.getMail());

    return dao;
  }

  public static UserSession toModel(UserSessionDao dao) {
    UserSession model = new UserSession();
    model.setMail(dao.getMail());
    model.setSessionId(dao.getSessionId());

    return model;
  }
}
