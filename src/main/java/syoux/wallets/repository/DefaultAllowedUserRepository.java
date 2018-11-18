package syoux.wallets.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultAllowedUserRepository implements AllowedUserRepository {
  private static final String PATH = "allowedUsers";
  private static final Logger logger = LoggerFactory.getLogger(DefaultAllowedUserRepository.class);
  private DatabaseReference reference;
  private List<String> allowedUsers;

  public DefaultAllowedUserRepository() {
    this(FirebaseDatabase.getInstance());
  }

  public DefaultAllowedUserRepository(FirebaseDatabase database) {
    this.allowedUsers = new ArrayList<>();
    this.reference = database.getReference();
    this.reference.child(PATH).addValueEventListener(this);
  }

  @Override
  public String get(String mail) {
    if (this.allowedUsers.contains(mail)) {
      return mail;
    }

    return null;
  }

  @Override
  public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot children: snapshot.getChildren()) {
      String allowedUser = children.getValue(String.class);
      this.allowedUsers.add(allowedUser);
    }
  }

  @Override
  public void onCancelled(DatabaseError error) {
  }
}
