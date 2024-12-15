package group.luka.bookie;

import blacbox.project.rawp.config.RestApiWebProviderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"group.luka.bookie.repo"})
@Import({RestApiWebProviderConfig.class, BookieAppConfig.class})
public class BookieAppMain {
    public static void main(String[] args) {
        SpringApplication.run(BookieAppMain.class, args);
    }

}