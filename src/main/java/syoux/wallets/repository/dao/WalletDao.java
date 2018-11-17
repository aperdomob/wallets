package syoux.wallets.repository.dao;

import lombok.Data;
import syoux.wallets.model.Wallet;

import java.time.ZonedDateTime;

public @Data  class WalletDao {
  private String name;
  private String description;
  private String status;
  private double goal;
  private long dueDate;
  private boolean isPostponable;
  private int priority;
}
