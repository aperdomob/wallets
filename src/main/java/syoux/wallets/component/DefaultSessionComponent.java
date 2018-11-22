package syoux.wallets.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import syoux.wallets.domain.GoogleUserDomain;
import syoux.wallets.domain.SessionDomain;
import syoux.wallets.domain.security.AesEncrypt;
import syoux.wallets.model.UserWallet;
import syoux.wallets.model.UserSession;

@Component
public class DefaultSessionComponent implements SessionComponent {
  private final SessionDomain sessionDomain;
  private final AesEncrypt aesEncrypt;
  private final GoogleUserDomain googleUserDomain;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public DefaultSessionComponent(
      final SessionDomain sessionDomain,
      final GoogleUserDomain googleUserDomain,
      final AesEncrypt aesEncrypt,
      final BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.sessionDomain = sessionDomain;
    this.googleUserDomain = googleUserDomain;
    this.aesEncrypt = aesEncrypt;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public void init(UserSession session) {
    this.sessionDomain.init(session);
  }

  @Override
  public UserWallet loadUser(String username) throws Exception {
    UserSession session = this.sessionDomain.getSession(username);

    if (session != null) {
      String uid = this.googleUserDomain.getUserUid(username);

      if (uid != null) {
        String secret = System.getenv("SESSION_SECRET");
        String aggregator = System.getenv("SESSION_AGGREGATOR");
        String prefix = System.getenv("SESSION_PREFIX");
        long module = 10000000L;


        long ivSuffix = ((session.getSessionId() % module) * (Long.parseLong(aggregator) % module)) % module;
        String iv = prefix + Long.toString(ivSuffix);
        String encryptedUid = this.aesEncrypt.encrypt(uid, secret.getBytes(), iv.getBytes());
        String token = bCryptPasswordEncoder.encode(encryptedUid);

        UserWallet user = new UserWallet();
        user.setUsername(username);
        user.setPassword(token);

        return user;
      }
    }

    return null;
  }
}
