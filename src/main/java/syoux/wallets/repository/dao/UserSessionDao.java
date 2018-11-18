package syoux.wallets.repository.dao;

import lombok.Data;

@Data
public class UserSessionDao {
  private long sessionId;
  private String mail;
}
