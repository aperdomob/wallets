package syoux.wallets.repository.transform;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTransform {
  public static ZonedDateTime getZoneDateTime(long time) {
    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
  }

  public static long getMilliseconds(ZonedDateTime date) {
    return date.toInstant().toEpochMilli();
  }
}
