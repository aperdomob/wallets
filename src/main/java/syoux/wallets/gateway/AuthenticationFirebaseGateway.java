package syoux.wallets.gateway;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFirebaseGateway {
  public AuthenticationFirebaseGateway() {}

  public boolean existsUser(String uid) {
    try {
      UserRecord user = FirebaseAuth.getInstance().getUser(uid);

      return user != null;
    } catch (FirebaseAuthException e) {
      return false;
    }
  }

  public String getUid(String mail) {
    try {
      UserRecord user = FirebaseAuth.getInstance().getUserByEmail(mail);

      return user.getUid();
    } catch (FirebaseAuthException e) {
      return null;
    }
  }
}
