package syoux.wallets.domain.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import org.junit.Test;

public class AesEncryptTest {
  private AesEncrypt aesEncrypt;
  byte[] key = { 1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6 };
  byte[] ivk = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

  @Test
  public void encryptDecryptTest() throws Exception {
    String text = "this is my text to encrypt";
    aesEncrypt = new AesEncrypt();

    String encryptedText = aesEncrypt.encrypt(text, key, ivk);
    String decryptedText = aesEncrypt.decrypt(encryptedText, key, ivk);

    assertThat(text, equalTo(decryptedText));

  }

  @Test
  public void decryptTest() throws Exception {
    aesEncrypt = new AesEncrypt();
    String text = "this is my text to encrypt";

    String encryptedText = "UJvPb5Lnx4/ul82JSZcHEnLnxA0bS+oBswPyHjdWoSo=";
    String decryptedText = aesEncrypt.decrypt(encryptedText, key, ivk);

    assertThat(text, equalTo(decryptedText));
  }
}
