package patienttracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import patienttracker.model.Appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;


@SpringBootTest
class ApplicationModelTests {

	@Test
	void contextLoads() {
	}

    @Test
    void defaultConstructorNullTest() {

        Appointment appointment = new Appointment();

        assertNull(appointment.getId());
        assertNull(appointment.getDoctorId());
        assertNull(appointment.getPatientId());
        assertNull(appointment.getDateTime());
        assertNull(appointment.getStatus());
        assertNull(appointment.getPurpose());
    }

    @Test
    void parameterizedConstructorValuesTest() {

        Long id = 1L;
        Long doctorId = 101L;
        Long patientId = 201L;
        LocalDateTime dateTime = LocalDateTime.now();
        Character status = 'S';
        String purpose = "Regular Checkup";

        Appointment appointment = new Appointment(id, doctorId, patientId, dateTime, status, purpose);

        assertEquals(id, appointment.getId());
        assertEquals(doctorId, appointment.getDoctorId());
        assertEquals(patientId, appointment.getPatientId());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals(status, appointment.getStatus());
        assertEquals(purpose, appointment.getPurpose());
    }

    @Test
    void setIdTest() {

        Long id = 1L;
        Appointment appointment = new Appointment();

        appointment.setId(id);

        assertEquals(id, appointment.getId());
    }

    @Test
    void setDoctorIdTest() {

        Long doctorId = 101L;
        Appointment appointment = new Appointment();

        appointment.setDoctorId(doctorId);

        assertEquals(doctorId, appointment.getDoctorId());
    }

    @Test
    void setPatientIdTest() {

        Long patientId = 201L;
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);

        assertEquals(patientId, appointment.getPatientId());
    }

    @Test
    void setDateTimeTest() {

        LocalDateTime dateTime = LocalDateTime.now();
        Appointment appointment = new Appointment();

        appointment.setDateTime(dateTime);

        assertEquals(dateTime, appointment.getDateTime());
    }

    @Test
    void setStatusTest() {

        Character status = 'S';
        Appointment appointment = new Appointment();

        appointment.setStatus(status);

        assertEquals(status, appointment.getStatus());
    }

    @Test
    void setPurposeTest() {

        String purpose = "Regular Checkup";
        Appointment appointment = new Appointment();

        appointment.setPurpose(purpose);

        assertEquals(purpose, appointment.getPurpose());
    }

    @Test
    void toStringTest() {

        Long id = 1L;
        Long doctorId = 101L;
        Long patientId = 201L;
        LocalDateTime dateTime = LocalDateTime.now();
        Character status = 'S';
        String purpose = "Regular Checkup";

        Appointment appointment = new Appointment(id, doctorId, patientId, dateTime, status, purpose);

        String expectedString = "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", purpose='" + purpose + '\'' +
                '}';
        assertEquals(expectedString, appointment.toString());
    }

}
