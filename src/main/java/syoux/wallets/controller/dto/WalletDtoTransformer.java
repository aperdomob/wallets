package syoux.wallets.controller.dto;

import syoux.wallets.controller.dto.body.WalletBodyDto;
import syoux.wallets.controller.dto.response.WalletResponseDto;
import syoux.wallets.model.Wallet;

public class WalletDtoTransformer {
  public static Wallet toModel(WalletBodyDto walletBody) {
    Wallet wallet = new Wallet();
    wallet.setStatus(walletBody.getStatus());
    wallet.setPriority(walletBody.getPriority());
    wallet.setPostponable(walletBody.isPostponable());
    wallet.setName(walletBody.getName());
    wallet.setId(walletBody.getId());
    wallet.setGoal(walletBody.getGoal());
    wallet.setDueDate(walletBody.getDueDate());
    wallet.setDescription(walletBody.getDescription());

    return wallet;
  }

  public static WalletResponseDto toResponse(Wallet wallet) {
    WalletResponseDto walletResponseDto = new WalletResponseDto();
    walletResponseDto.setStatus(wallet.getStatus());
    walletResponseDto.setPriority(wallet.getPriority());
    walletResponseDto.setPostponable(wallet.isPostponable());
    walletResponseDto.setName(wallet.getName());
    walletResponseDto.setId(wallet.getId());
    walletResponseDto.setGoal(wallet.getGoal());
    walletResponseDto.setDueDate(wallet.getDueDate());
    walletResponseDto.setDescription(wallet.getDescription());

    return walletResponseDto;
  }
}
