package patienttracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import patienttracker.model.Patient;
import patienttracker.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;


@SpringBootTest
class PatientModelTests {

	@Test
	void contextLoads() {
	}

    @Test
    void defaultConstructorNullTest() {
        
        Patient patient = new Patient();

        assertNull(patient.getId());
        assertNull(patient.getUser());
        assertNull(patient.getHistory());
        assertNull(patient.getAllergies());
        assertNull(patient.getChronicConditions());
    }

    @Test
    void parameterizedConstructorValuesTest() {

        String history = "Patient history";
        String allergies = "Patient allergies";
        String chronicConditions = "Patient chronic conditions";

        Patient patient = new Patient(history, allergies, chronicConditions);

        assertNull(patient.getId()); 
        assertNull(patient.getUser()); 
        assertEquals(history, patient.getHistory());
        assertEquals(allergies, patient.getAllergies());
        assertEquals(chronicConditions, patient.getChronicConditions());
    }

    @Test
    void settersTest() {
        Patient patient = new Patient();

        Long id = 1L;
        User user = new User(1L, "janedoe123", "password123", "Jane", "Doe", LocalDate.of(1980, 2, 13), 'F', 'P'); 
        String history = "Patient history";
        String allergies = "Patient allergies";
        String chronicConditions = "Patient chronic conditions";

        patient.setId(id);
        patient.setUser(user);
        patient.setHistory(history);
        patient.setAllergies(allergies);
        patient.setChronicConditions(chronicConditions);

        assertEquals(id, patient.getId());
        assertEquals(user, patient.getUser());
        assertEquals(history, patient.getHistory());
        assertEquals(allergies, patient.getAllergies());
        assertEquals(chronicConditions, patient.getChronicConditions());
    }

    
    @Test
    public void testToString() {
        Patient patient = new Patient();
        Long id = 1L;
        User user = new User(1L, "janedoe123", "password123", "Jane", "Doe", LocalDate.of(1980, 2, 13), 'F', 'P'); 
        String history = "Patient history";
        String allergies = "Patient allergies";
        String chronicConditions = "Patient chronic conditions";        
        
        patient.setId(1L);
        patient.setUser(user);
        patient.setHistory("Patient history");
        patient.setAllergies("Patient allergies");
        patient.setChronicConditions("Patient chronic conditions");

        String expectedString = "Patient{" +
                "id=" + id +
                ", user=" + user +
                ", history='" + history + '\'' +
                ", allergies='" + allergies + '\'' +
                ", chronicConditions='" + chronicConditions + '\'' +
                '}';
    
        assertEquals(expectedString, patient.toString());

    }


}
