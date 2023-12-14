package patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patienttracker.model.Appointment;
import patienttracker.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments() {
        return this.appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return this.appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return this.appointmentRepository.findByPatientId(patientId);
    }

    public void updateAppointmentDateTime(Long appointmentId, LocalDateTime newDateTime) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setDateTime(newDateTime);
        this.appointmentRepository.save(appointment);
    }

    public void updateAppointmentStatus(Long appointmentId, Character newStatus) {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setStatus(newStatus);
        this.appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return this.appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalStateException("The appointment with ID " + appointmentId + " does not exist"));
    }

}
