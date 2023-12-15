package patienttracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents a doctor in the patient tracking system.
 * Doctors are stored in the "doctor" table.
 */

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    private Long id; // unique
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user; // unique
    private String specialization; // field of specialization
    private Integer yoe; // 'years of experience'
    private String qualification; // MD, MBBS, etc.
    private String hospital; // associated hospital

    public Doctor() {

    }

    public Doctor(String specialization, Integer yoe, String qualification, String hospital) {
        this.specialization = specialization;
        this.yoe = yoe;
        this.qualification = qualification;
        this.hospital = hospital;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getYoe() {
        return yoe;
    }

    public void setYoe(Integer yoe) {
        this.yoe = yoe;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    /**
     * Returns a string representation of the doctor.
     *
     * @return A string representation of the doctor.
     */

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", user=" + user +
                ", specialization='" + specialization + '\'' +
                ", yoe=" + yoe +
                ", qualification='" + qualification + '\'' +
                ", hospital='" + hospital + '\'' +
                '}';
    }

}
