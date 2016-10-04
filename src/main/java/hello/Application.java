package hello;

import hello.entity.User;
import hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of Users
            repository.save(new User("Jack", "jack@sample.com"));
            repository.save(new User("Chris", "isi.cho@gmail.com"));
            repository.save(new User("Kim", "kim@sample.com"));
            repository.save(new User("David", "david@sample.com"));
            repository.save(new User("Michelle", "michelle@sample.com"));

            // fetch all Users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User User : repository.findAll()) {
                log.info(User.toString());
            }
            log.info("");

            // fetch an individual User by ID
            User User = repository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(User.toString());
            log.info("");

            // fetch Users by last name
            log.info("User found with findByLastName('Chris'):");
            log.info("--------------------------------------------");
            for (User bauer : repository.findByName("Chris")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
}