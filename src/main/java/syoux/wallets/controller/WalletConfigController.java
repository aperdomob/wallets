package syoux.wallets.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("config/wallets")
public class WalletConfigController {
  public WalletConfigController() {}

  @RequestMapping(path="status", method= RequestMethod.GET)
  public List<String> getStatus() {
    List<String> result = new ArrayList<>();
    result.add("Created");
    result.add("Planned");
    result.add("Saving");
    result.add("Saved");
    result.add("Using");
    result.add("Completed");
    result.add("Suspended");

    return  result;
  }
}
