package patienttracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import patienttracker.model.Doctor;
import patienttracker.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;


@SpringBootTest
class DoctorModelTests {

	@Test
	void contextLoads() {
	}

    @Test
    void defaultConstructorNullTest() {
        
        Doctor doctor = new Doctor();

        assertNull(doctor.getId());
        assertNull(doctor.getUser());
        assertNull(doctor.getSpecialization());
        assertNull(doctor.getYoe());
        assertNull(doctor.getQualification());
        assertNull(doctor.getHospital());
    }

    @Test
    void parameterizedConstructorValuesTest() {

        String specialization = "Cardiology";
        Integer yoe = 8;
        String qualification = "MD";
        String hospital = "City Hospital";

        Doctor doctor = new Doctor(specialization, yoe, qualification, hospital);

        assertNull(doctor.getId()); 
        assertNull(doctor.getUser()); 
        assertEquals(specialization, doctor.getSpecialization());
        assertEquals(yoe, doctor.getYoe());
        assertEquals(qualification, doctor.getQualification());
        assertEquals(hospital, doctor.getHospital());
    }

    @Test
    void setIdTest() {

        Long id = 1L;
        Doctor doctor = new Doctor();

        doctor.setId(id);

        assertEquals(id, doctor.getId());
    }

    @Test
    void setDoctorIdTest() {

        User user = new User(1L, "johnsmith123", "password123", "John", "Smith", LocalDate.of(1990, 5, 15), 'M', 'D'); 
        
        Doctor doctor = new Doctor();

        doctor.setUser(user);

        assertEquals(user, doctor.getUser());
    }

    @Test
    void setSpecializationTest() {

        String specialization = "Orthopedics";
        Doctor doctor = new Doctor();

        doctor.setSpecialization(specialization);

        assertEquals(specialization, doctor.getSpecialization());
    }

    @Test
    void setYoeTest() {

        Integer yoe = 8;
        Doctor doctor = new Doctor();

        doctor.setYoe(yoe);

        assertEquals(yoe, doctor.getYoe());
    }

    @Test
    void setQualificationTest() {

        String qualification = "MS";
        Doctor doctor = new Doctor();

        doctor.setQualification(qualification);

        assertEquals(qualification, doctor.getQualification());
    }

    @Test
    void setHospitalTest() {

        String hospital = "Community Hospital";
        Doctor doctor = new Doctor();

        doctor.setHospital(hospital);

        assertEquals(hospital, doctor.getHospital());
    }

    @Test
    void toStringTest() {

        Long id = 1L;
        User user = new User(1L, "johnsmith123", "password123", "John", "Smith", LocalDate.of(1990, 5, 15), 'M', 'D'); 
        String specialization = "Neurology";
        Integer yoe = 10;
        String qualification = "DM";
        String hospital = "University Hospital";

        Doctor doctor = new Doctor(specialization, yoe, qualification, hospital);
        doctor.setId(id);
        doctor.setUser(user);

        String expectedString = "Doctor{" +
                "id=" + id +
                ", user=" + user +
                ", specialization='" + specialization + '\'' +
                ", yoe=" + yoe +
                ", qualification='" + qualification + '\'' +
                ", hospital='" + hospital + '\'' +
                '}';

        assertEquals(expectedString, doctor.toString());
    }

}
