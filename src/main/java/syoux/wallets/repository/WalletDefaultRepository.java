package syoux.wallets.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import syoux.wallets.model.Wallet;
import syoux.wallets.repository.dao.WalletDao;
import syoux.wallets.repository.transform.WalletTransform;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WalletDefaultRepository implements WalletRepository {
  private static final String PATH = "wallets";
  private static final Logger logger = LoggerFactory.getLogger(WalletDefaultRepository.class);
  private Map<String, Wallet> wallets;
  private DatabaseReference reference;

  public WalletDefaultRepository() {
    this(FirebaseDatabase.getInstance());
  }

  public WalletDefaultRepository(FirebaseDatabase database) {
    this.wallets = new HashMap<>();
    this.reference = database.getReference();
    this.reference.child(PATH).addValueEventListener(this);
  }

  @Override
  public Wallet save(Wallet wallet) {
    WalletDao dao = WalletTransform.fromWallet(wallet);

    reference.child(PATH).child(wallet.getId()).setValueAsync(dao);

    return wallet;
  }

  @Override
  public Wallet get(String walletId) {
    return this.wallets.get(walletId);
  }

  @Override
  public Collection<Wallet> getAll() {
    return this.wallets.values();
  }

  @Override
  public boolean delete(String walletId) {
    if (this.wallets.containsKey(walletId)) {
      this.wallets.remove(walletId);
      this.reference.child(PATH).child(walletId).removeValueAsync();

      return true;
    }

    return false;
  }

  @Override
  public void onDataChange(DataSnapshot snapshot) {
    for(DataSnapshot children: snapshot.getChildren()) {
      WalletDao dao = children.getValue(WalletDao.class);
      String id = children.getKey();

      Wallet model = WalletTransform.createModel(dao, id);

      this.wallets.put(id, model);
    }
  }

  @Override
  public void onCancelled(DatabaseError error) {

  }
}
