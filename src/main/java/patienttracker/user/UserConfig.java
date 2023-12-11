package patienttracker.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User u1 = new User(
                    "doc",
                    "***",
                    "John",
                    "Doe",
                    LocalDate.of(1980, Month.AUGUST, 10),
                    'M',
                    'D'
            );

            User u2 = new User(
                    "janpat",
                    "****",
                    "Jane",
                    "Dawn",
                    LocalDate.of(1985, Month.JUNE, 28),
                    'F',
                    'P'
            );

            User u3 = new User(
                    "rich",
                    "*****",
                    "Richard",
                    "Parker",
                    LocalDate.of(1990, Month.JANUARY, 12),
                    'M',
                    'P'
            );

            userRepository.saveAll(List.of(u1, u2, u3));
        };
    }

}
