package patienttracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents a patient in the patient tracking system.
 * Patients are stored in the "patient" table.
 */

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    private String history;
    private String allergies;
    private String chronicConditions;

    public Patient() {

    }

    public Patient(String history, String allergies, String chronicConditions) {
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

    /**
     * Returns a string representation of the patient.
     *
     * @return A string representation of the patient.
     */

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
