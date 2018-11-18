package syoux.wallets.controller.dto.body;

import lombok.Data;

@Data
public class UserSessionBody {
  private long sessionId;
  private String mail;
}
