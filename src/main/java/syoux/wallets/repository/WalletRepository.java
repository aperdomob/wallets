package syoux.wallets.repository;

import com.google.firebase.database.ValueEventListener;
import syoux.wallets.model.Wallet;

import java.util.Collection;

public interface WalletRepository extends ValueEventListener {
  Wallet save(Wallet wallet);
  Wallet get(String walletId);
  Collection<Wallet> getAll();
  boolean delete(String walletId);
}
