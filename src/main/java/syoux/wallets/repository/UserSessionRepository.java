package syoux.wallets.repository;

import syoux.wallets.repository.dao.UserSessionDao;

public interface UserSessionRepository {
  void save(UserSessionDao dao);
}
