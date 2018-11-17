package syoux.wallets.repository.transform;

import syoux.wallets.model.Wallet;
import syoux.wallets.repository.dao.WalletDao;

public class WalletTransform {
  public static WalletDao fromWallet(Wallet wallet) {
    WalletDao dao = new WalletDao();

    dao.setName(wallet.getName());
    dao.setDescription(wallet.getDescription());
    dao.setStatus((wallet.getDescription()));
    dao.setGoal(wallet.getGoal());
    dao.setPostponable(wallet.isPostponable());
    dao.setPriority(wallet.getPriority());
    dao.setDueDate(DateTransform.getMilliseconds(wallet.getDueDate()));

    return dao;
  }

  public static Wallet createModel(WalletDao dao, String walletId) {
    Wallet model = new Wallet();
    model.setDescription(dao.getDescription());
    model.setDueDate(DateTransform.getZoneDateTime(dao.getDueDate()));
    model.setGoal(dao.getGoal());
    model.setId(walletId);
    model.setName(dao.getName());
    model.setPostponable(dao.isPostponable());
    model.setPriority(dao.getPriority());
    model.setStatus(dao.getStatus());

    return model;
  }
}
