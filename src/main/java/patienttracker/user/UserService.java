package patienttracker.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User(1L,
                        "doc",
                        "***",
                        "John",
                        "Doe",
                        LocalDate.of(1980, Month.AUGUST, 10),
                        'M',
                        'D')
        );
    }

}
