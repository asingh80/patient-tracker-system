package patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patienttracker.model.Doctor;
import patienttracker.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void addNewDoctor(Doctor doctor) {
        this.doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctors() {
        return this.doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return this.doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("The doctor with ID " + id + " does not exist"));
    }

}
