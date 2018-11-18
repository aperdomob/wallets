package syoux.wallets.domain;

import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Component;
import syoux.wallets.model.UserSession;
import syoux.wallets.repository.AllowedUserRepository;
import syoux.wallets.repository.UserSessionRepository;
import syoux.wallets.repository.dao.UserSessionDao;
import syoux.wallets.repository.mapper.UserSessionMapper;

@Component
public class SessionDomain {
  private final UserSessionRepository userSessionRepository;
  private final AllowedUserRepository allowedUserRepository;

  public SessionDomain(
      UserSessionRepository userSessionRepository,
      AllowedUserRepository allowedUserRepository) {
    this.userSessionRepository = userSessionRepository;
    this.allowedUserRepository = allowedUserRepository;
  }

  public void init(UserSession session) {
    if (this.allowedUserRepository.get(session.getMail()) == null) {
      throw new AuthorizationServiceException("the user is not authorized");
    }

    UserSessionDao dao = UserSessionMapper.toDao(session);

    this.userSessionRepository.save(dao);
  }
}
