package patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patienttracker.model.User;
import patienttracker.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByUsername = this.userRepository.findUserByUsername(user.getUsername());
        if (userByUsername.isPresent()) {
            throw new IllegalStateException("Username already exists");
        }
        this.userRepository.save(user);
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
}
