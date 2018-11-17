package syoux.wallets.service;

import syoux.wallets.model.Wallet;

import java.util.Collection;

public interface WalletService {
  Wallet create(Wallet wallet);
  Wallet get(String walletId);
  Collection<Wallet> getAll();
}
