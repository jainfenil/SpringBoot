package academy.ennate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run();
       /*  For Changing profile
           java -jar -Dspring.profiles.active=production demo-0.0.1-SNAPSHOT.jar
       * */
    }
}
