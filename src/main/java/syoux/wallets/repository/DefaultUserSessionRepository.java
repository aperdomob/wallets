package syoux.wallets.repository;

import org.springframework.stereotype.Repository;
import syoux.wallets.repository.dao.UserSessionDao;

@Repository
public class DefaultUserSessionRepository implements UserSessionRepository {
  @Override
  public void save(UserSessionDao dao) {

  }
}
