package group.luka.bookie;

import blacbox.project.rawp.config.RestApiWebProviderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RestApiWebProviderConfig.class, BookieAppConfig.class})
public class BookieAppMain {
    public static void main(String[] args) {
        SpringApplication.run(BookieAppMain.class, args);
    }

}