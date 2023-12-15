package patienttracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    private String history;
    private String allergies;
    private String chronicConditions;

    public Patient() {

    }

    public Patient(User user, String history, String allergies, String chronicConditions) {
        this.user = user;
        this.history = history;
        this.allergies = allergies;
        this.chronicConditions = chronicConditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getChronicConditions() {
        return chronicConditions;
    }

    public void setChronicConditions(String chronicConditions) {
        this.chronicConditions = chronicConditions;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", user=" + user +
                ", history='" + history + '\'' +
                ", allergies='" + allergies + '\'' +
                ", chronicConditions='" + chronicConditions + '\'' +
                '}';
    }

}
