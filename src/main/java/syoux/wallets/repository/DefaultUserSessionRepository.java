package syoux.wallets.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.hsqldb.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import syoux.wallets.repository.dao.UserSessionDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DefaultUserSessionRepository implements UserSessionRepository {
  private static final String PATH = "session";
  private static final Logger logger = LoggerFactory.getLogger(DefaultAllowedUserRepository.class);
  private DatabaseReference reference;
  private Map<String, UserSessionDao> sessions;
  private Map<String, String> ids;

  public DefaultUserSessionRepository() {
    this(FirebaseDatabase.getInstance());
  }

  public DefaultUserSessionRepository(FirebaseDatabase database) {
    this.sessions = new HashMap<>();
    this.ids = new HashMap<>();
    this.reference = database.getReference();
    this.reference.child(PATH).addValueEventListener(this);
  }


  @Override
  public void save(UserSessionDao dao) {
    DatabaseReference childReference = this.reference.child(PATH);

    String id  = this.ids.get(dao.getMail());

    if (id == null) {
      id = childReference.push().getKey();
    }

    childReference.child(id).setValueAsync(dao);
  }

  @Override
  public UserSessionDao get(String mail) {
    return this.sessions.get(mail);
  }

  @Override
  public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot children: snapshot.getChildren()) {
      UserSessionDao sessions = children.getValue(UserSessionDao.class);
      this.sessions.put(sessions.getMail(), sessions);
      this.ids.put(sessions.getMail(), children.getKey());
    }
  }

  @Override
  public void onCancelled(DatabaseError error) {

  }
}
