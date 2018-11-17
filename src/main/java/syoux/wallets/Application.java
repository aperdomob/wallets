package syoux.wallets;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    List<FirebaseApp> firebaseApps = FirebaseApp.getApps();

    if(firebaseApps.isEmpty()) {
      String url = System.getenv("FIREBASE_URL") + System.getenv("GOOGLE_CREDENTIALS_URI") + "?alt=media&token=" + System.getenv("STORE_FIREBASE_TOKEN");
      URLConnection connection = new URL(url).openConnection();

      InputStream serviceAccount = connection.getInputStream();

      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl(System.getenv("DATABASE_URL"))
          .build();

      FirebaseApp.initializeApp(options);
    }

    ApplicationContext context = SpringApplication.run(Application.class, args);
    logger.info("Let's inspect the beans provided by Spring Bot");

    String[] beanNames = context.getBeanDefinitionNames();
    Arrays.sort(beanNames);

    for(String beanName: beanNames) {
      logger.info(beanName);
    }
  }
}
