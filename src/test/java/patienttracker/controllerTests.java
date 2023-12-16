package patienttracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import patienttracker.model.Appointment;
import patienttracker.service.AppointmentService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    void addNewAppointment() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

        String formattedDateTime = LocalDateTime.now().format(formatter);
        LocalDateTime formatdt = LocalDateTime.parse(formattedDateTime, formatter);
        Appointment appointment = new Appointment(1L, 2L, 3L, formatdt, 'S', "Follow-up");

        restTemplate.postForObject("http://localhost:" + port + "/appointments", appointment, Void.class);

        List<Appointment> appointments = appointmentService.getAppointments();
        assertEquals(1, appointments.size());
        assertEquals(appointment.toString(), appointments.get(0).toString());
    }

 }

