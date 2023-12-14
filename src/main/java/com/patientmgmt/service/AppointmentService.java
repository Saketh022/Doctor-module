package com.patientmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmgmt.entity.Appointment;
import com.patientmgmt.repository.AppointmentRepository;


// Service annotation to indicate that this class is a Spring service
@Service
public class AppointmentService {
	
	// Autowiring the AppointmentRepository for database interaction
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	// Method to retrieve all appointments from the database
	public List<Appointment> getAppointmentsFromDatabase(){
		return appointmentRepository.findAll();
	}
	
	// Method to retrieve an appointment by its ID from the database
	public Optional<Appointment> getappointmentsById(Long appointmentId){
		return appointmentRepository.findById(appointmentId);
	}
	
	// Method to create a new appointment in the database
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	// Method to update an existing appointment in the database
	public String updateAppointment(Long appointmentId, Appointment newAppointment) {
		Optional<Appointment> existingAppointment = appointmentRepository.findById(appointmentId);
		
		if(existingAppointment.isPresent()) {
			Appointment foundAppointment = existingAppointment.get();
			// Updating appointment details with the new values
			foundAppointment.setAppointmentLocalDate(newAppointment.getAppointmentDate());
			foundAppointment.setAppointmentLocalTime(newAppointment.getAppointmentTime());
			foundAppointment.setAppointmentDuration(newAppointment.getAppointmentDuration());
			foundAppointment.setAppointmentReason(newAppointment.getAppointmentReason());
			
			// Saving the updated appointment in the database
			appointmentRepository.save(foundAppointment);
 
			return "Appointment Updated";
		} else {
			// If the appointment with the given ID is not found
			return "Appointment Not Updated";
		}
	}
	
	// Method to delete an appointment from the database by its ID
	public void deleteAppointment(Long appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}
}
