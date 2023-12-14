package patienttracker.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import patienttracker.model.Appointment;
import patienttracker.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class AppointmentConfig {

    @Bean
    CommandLineRunner appointmentCommandLineRunner(AppointmentRepository appointmentRepository) {
        return args -> {
            Appointment a1 = new Appointment(
                    1L,
                    5L,
                    6L,
                    LocalDateTime.of(2024, Month.JANUARY, 9, 12, 30),
                    'S',
                    "general check-up"
            );

            Appointment a2 = new Appointment(
                    2L,
                    5L,
                    7L,
                    LocalDateTime.of(2024, Month.JANUARY, 10, 15, 30),
                    'S',
                    "general check-up"
            );

            Appointment a3 = new Appointment(
                    3L,
                    10L,
                    9L,
                    LocalDateTime.of(2024, Month.JANUARY, 11, 17, 30),
                    'S',
                    "general check-up"
            );

            appointmentRepository.saveAll(List.of(a1, a2, a3));
        };
    }

}
