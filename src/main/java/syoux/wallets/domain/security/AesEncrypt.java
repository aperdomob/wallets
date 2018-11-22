package syoux.wallets.domain.security;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Component
public class AesEncrypt {
  private final String ALGORITHM = "AES/CBC/PKCS5PADDING";


  public AesEncrypt() {}

  /**
   * Encrypt a string with AES algorithm.
   *
   * @param data is a string
   * @return the encrypted string
   */
  public String encrypt(String data, byte[] key, byte[] newIv) throws Exception {
    byte[] dataBytes = data.getBytes("utf-8");

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
    IvParameterSpec iv = new IvParameterSpec(newIv);
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
    byte[] encrypted = cipher.doFinal(dataBytes);

    return Base64.getEncoder().encodeToString(encrypted);
  }

  /**
   * Decrypt a string with AES algorithm.
   *
   * @param encryptedData is a string
   * @return the decrypted string
   */
  public String decrypt(String encryptedData, byte[] key, byte[] newIv) throws Exception {
    byte[] srcBytes = Base64.getDecoder().decode(encryptedData.getBytes());
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
    IvParameterSpec iv = new IvParameterSpec(newIv);
    cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
    byte[] decrypted = cipher.doFinal(srcBytes);

    return new String(decrypted, "utf-8");
  }
}

