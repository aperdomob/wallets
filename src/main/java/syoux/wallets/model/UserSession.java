package syoux.wallets.model;

import lombok.Data;

@Data
public class UserSession {
  private long sessionId;
  private String mail;
}
