package patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patienttracker.dto.RegistrationRequest;
import patienttracker.model.Doctor;
import patienttracker.model.Patient;
import patienttracker.model.User;
import patienttracker.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public UserService(UserRepository userRepository, DoctorService doctorService, PatientService patientService) {
        this.userRepository = userRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void addNewUser(RegistrationRequest req) {
        User user = req.getUser();
        Optional<User> userByUsername = this.userRepository.findUserByUsername(user.getUsername());
        if (userByUsername.isPresent()) {
            throw new IllegalStateException("Username already exists");
        }

        if (user.getUserType() == 'D') {
            Doctor doctor = req.getDoctor();
            user.setDoctor(doctor);
            doctor.setUser(user);
            this.userRepository.save(user);
            this.doctorService.addNewDoctor(doctor);
        } else {
            Patient patient = req.getPatient();
            user.setPatient(patient);
            patient.setUser(user);
            this.userRepository.save(user);
            this.patientService.addNewPatient(patient);
        }
    }

    public void deleteUser(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new IllegalStateException("The user with ID " + id + " does not exist");
        }
        this.userRepository.deleteById(id);
    }

    public void updateUser(Long id, String username, String password) {
        User user = this.getUserById(id);

        if (username != null && !username.isEmpty() && !username.equals(user.getUsername())) {
            Optional<User> userByUsername = this.userRepository.findUserByUsername(username);
            if (userByUsername.isPresent()) {
                throw new IllegalStateException("Username already exists");
            }
            user.setUsername(username);
        }

        if (password != null && !password.isEmpty() && !password.equals(user.getPassword())) {
            user.setPassword(password);
        }

        this.userRepository.save(user);
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("The user with ID " + id + " does not exist"));
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username)
                .orElseThrow(() -> new IllegalStateException("The user with username " + username + " does not exist"));
    }

}
