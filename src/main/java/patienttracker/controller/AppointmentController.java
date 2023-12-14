package patienttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patienttracker.model.Appointment;
import patienttracker.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments() {
        return this.appointmentService.getAppointments();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return this.appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return this.appointmentService.getAppointmentsByPatientId(patientId);
    }

    @PutMapping("/updateDateTime/{appointmentId}")
    public void updateAppointmentDateTime(@PathVariable Long appointmentId,
                                          @RequestParam LocalDateTime newDateTime) {
        this.appointmentService.updateAppointmentDateTime(appointmentId, newDateTime);
    }

    @PutMapping("/updateStatus/{appointmentId}")
    public void updateAppointmentStatus(@PathVariable Long appointmentId,
                                          @RequestParam Character newStatus) {
        this.appointmentService.updateAppointmentStatus(appointmentId, newStatus);
    }

}
