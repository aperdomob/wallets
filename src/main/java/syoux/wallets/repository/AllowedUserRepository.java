package syoux.wallets.repository;

import com.google.firebase.database.ValueEventListener;

public interface AllowedUserRepository extends ValueEventListener {
  String get(String mail);
}
