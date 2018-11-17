package syoux.wallets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import syoux.wallets.controller.dto.WalletDtoTransformer;
import syoux.wallets.controller.dto.body.WalletBodyDto;
import syoux.wallets.controller.dto.response.WalletResponseDto;
import syoux.wallets.model.Wallet;
import syoux.wallets.service.WalletService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@CrossOrigin
@RestController
@RequestMapping("wallets")
public class WalletController {
  @Autowired
  private final WalletService walletService;

  public WalletController(final WalletService walletService) {
    this.walletService = walletService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public WalletResponseDto getAll() {
    WalletResponseDto dto = new WalletResponseDto();
    dto.setDescription("My Description");
    dto.setDueDate(ZonedDateTime.now(ZoneId.systemDefault()));
    dto.setGoal(20000);
    dto.setId("myId");
    dto.setName("This is an example");
    dto.setStatus("Created");

    return dto;
  }

  @RequestMapping(method = RequestMethod.POST)
  public WalletResponseDto save(@RequestBody WalletBodyDto walletBody) {
    Wallet wallet = WalletDtoTransformer.toModel(walletBody);
    Wallet walletResult = this.walletService.create(wallet);

    return WalletDtoTransformer.toResponse(walletResult);
  }
}
