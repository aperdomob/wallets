package syoux.wallets.repository;

import com.google.firebase.database.ValueEventListener;
import syoux.wallets.repository.dao.UserSessionDao;

public interface UserSessionRepository extends ValueEventListener {
  void save(UserSessionDao dao);

  UserSessionDao get(String mail);
}
