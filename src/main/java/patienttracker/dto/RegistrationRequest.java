package patienttracker.dto;

import patienttracker.model.Doctor;
import patienttracker.model.Patient;
import patienttracker.model.User;

public class RegistrationRequest {

    private User user;
    private Doctor doctor;
    private Patient patient;

    public RegistrationRequest(User user, Doctor doctor, Patient patient) {
        this.user = user;
        this.doctor = doctor;
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Character getUserType() {
        return user.getUserType();
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "user=" + user +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }

}
