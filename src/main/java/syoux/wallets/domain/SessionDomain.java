package syoux.wallets.domain;

import org.springframework.stereotype.Component;
import syoux.wallets.model.UserSession;
import syoux.wallets.repository.UserSessionRepository;
import syoux.wallets.repository.dao.UserSessionDao;
import syoux.wallets.repository.mapper.UserSessionMapper;

@Component
public class SessionDomain {
  private final UserSessionRepository userSessionRepository;

  public SessionDomain(UserSessionRepository userSessionRepository) {
    this.userSessionRepository = userSessionRepository;
  }

  public void init(UserSession session) {
    UserSessionDao dao = UserSessionMapper.toDao(session);

    this.userSessionRepository.save(dao);

  }
}
