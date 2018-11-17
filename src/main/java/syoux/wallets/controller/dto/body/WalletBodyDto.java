package syoux.wallets.controller.dto.body;

import lombok.Data;

import java.time.ZonedDateTime;

public @Data class WalletBodyDto {
  private String id;
  private String name;
  private String description;
  private String status;
  private double goal;
  private ZonedDateTime dueDate;
  private boolean isPostponable;
  private int priority;
}
