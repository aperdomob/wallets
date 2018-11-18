package syoux.wallets.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.wallets.controller.dto.UserSessionTransformer;
import syoux.wallets.controller.dto.body.UserSessionBody;
import syoux.wallets.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {
  private final SessionService sessionService;

  public SessionController(final SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @PostMapping()
  public void init(@RequestBody UserSessionBody user) {
    this.sessionService.init(UserSessionTransformer.toModel(user));
  }
}
