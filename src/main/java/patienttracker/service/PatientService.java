package patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patienttracker.model.Patient;
import patienttracker.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addNewPatient(Patient patient) {
        this.patientRepository.save(patient);
    }

    public List<Patient> getPatients() {
        return this.patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return this.patientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("The patient with ID " + id + " does not exist"));
    }

}
