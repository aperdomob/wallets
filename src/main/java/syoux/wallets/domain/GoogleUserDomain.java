package syoux.wallets.domain;

import org.springframework.stereotype.Component;
import syoux.wallets.gateway.AuthenticationFirebaseGateway;

@Component
public class GoogleUserDomain {
  private final AuthenticationFirebaseGateway authenticationFirebaseGateway;

  public GoogleUserDomain(final AuthenticationFirebaseGateway authenticationFirebaseGateway) {
    this.authenticationFirebaseGateway = authenticationFirebaseGateway;
  }

  public String getUserUid(String mail) {
    return this.authenticationFirebaseGateway.getUid(mail);
  }
}
