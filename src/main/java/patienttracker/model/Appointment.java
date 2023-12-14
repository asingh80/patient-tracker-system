package patienttracker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"doctor_id", "date_time"})
})
public class Appointment {

    @Id
    @SequenceGenerator(
            name = "appt_sequence",
            sequenceName = "appt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appt_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDateTime dateTime;
    private Character status;
    private String purpose;

    public Appointment() {

    }

    public Appointment(Long id, Long doctorId, Long patientId, LocalDateTime dateTime, Character status, String purpose) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.status = status;
        this.purpose = purpose;
    }

    public Appointment(Long doctorId, Long patientId, LocalDateTime dateTime, Character status, String purpose) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.status = status;
        this.purpose = purpose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", purpose='" + purpose + '\'' +
                '}';
    }

}
