package patienttracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import patienttracker.model.Doctor;
import patienttracker.model.Patient;
import patienttracker.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;


@SpringBootTest
class UserModelTests {

	@Test
	void contextLoads() {
	}

    @Test
    public void defaultConstructorNullTest() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getDoctor());
        assertNull(user.getPatient());
        assertNull(user.getUsername());
        assertNull(user.getPassword());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getDob());
        assertNull(user.getGender());
        assertNull(user.getUserType());
    }

    @Test
    public void parameterizedConstructorValuesTest() {
        Long id = 1L;
        String username = "johnsmith123";
        String password = "password123";
        String firstName = "John";
        String lastName = "Smith";
        LocalDate dob = LocalDate.of(1990, 5, 15);
        Character gender = 'M';
        Character userType = 'D';

        User user = new User(id, username, password, firstName, lastName, dob, gender, userType);

        assertEquals(id, user.getId());
        assertNull(user.getDoctor());
        assertNull(user.getPatient());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(dob, user.getDob());
        assertEquals(gender, user.getGender());
        assertEquals(userType, user.getUserType());
    }

    @Test
    public void setIdTest() {
        User user = new User();
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void setDoctorTest() {
        User user = new User();
        Doctor doctor = new Doctor(); 
        user.setDoctor(doctor);
        assertEquals(doctor, user.getDoctor());
    }

    @Test
    public void setPatientTest() {
        User user = new User();
        Patient patient = new Patient(); 
        user.setPatient(patient);
        assertEquals(patient, user.getPatient());
    }

    @Test
    public void setUsernameTest() {
        User user = new User();
        String username = "testUser";
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void setPasswordTest() {
        User user = new User();
        String password = "testPassword";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    public void setFirstNameTest() {
        User user = new User();
        String firstName = "John";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        User user = new User();
        String lastName = "Doe";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void setDobTest() {
        User user = new User();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        user.setDob(dob);
        assertEquals(dob, user.getDob());
    }

    @Test
    public void setGenderTest() {
        User user = new User();
        Character gender = 'M';
        user.setGender(gender);
        assertEquals(gender, user.getGender());
    }

    @Test
    public void setUserTypeTest() {
        User user = new User();
        Character userType = 'D';
        user.setUserType(userType);
        assertEquals(userType, user.getUserType());
    }

    @Test
    public void toStringTest() {
        User user = new User();
        assertNotNull(user.toString());
    }

}
