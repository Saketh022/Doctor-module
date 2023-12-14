package com.patientmgmt.controller;

import java.time.LocalTime;
import java.util.List;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.patientmgmt.entity.Appointment;
import com.patientmgmt.exception.ResourceNotFound;
import com.patientmgmt.service.AppointmentService;

import jakarta.validation.Valid;

//Annotation indicating that this class is a Spring MVC controller
@RestController

//Base mapping for all request mappings in this class
@RequestMapping("/api")
 
public class AppointmentController {
	 // Logger for logging messages
	Logger logger = LogManager.getLogger(AppointmentController.class);
	
	 // Autowired annotation for dependency injection of AppointmentService
	@Autowired
	AppointmentService service;
	
	// Endpoint to get a list of appointments
	@GetMapping("/appointments")
	public List<Appointment>viewAppointmentsList() throws ResourceNotFound {
		 // Log information about viewing the home page
		logger.info("view home page");
		// Retrieve the list of appointments from the service
		List<Appointment> listappointments = service.getAppointmentsFromDatabase();
		// Log information about the end of the home page
		logger.info("end of home page");
		if(listappointments.isEmpty()) {
			throw new ResourceNotFound("No Appointments are in the List");
		}else {
			// Return the list of appointments
			return listappointments;
		}
		
	}
	// Endpoint to find an appointment by ID
	@GetMapping("/appointments/{appointmentId}")
	public Optional<Appointment> findByAppointment(@PathVariable(value = "appointmentId") int id) throws ResourceNotFound{
		       
		// Call the service to get an appointment by ID
		Optional<Appointment> optionalAppointment=service.getappointmentsById((long)id);
		optionalAppointment.orElseThrow(()-> new ResourceNotFound("Appointment wiht id  not found "+id));
		return optionalAppointment;
	
	}

		       
	// Endpoint to create a new appointment
	@PostMapping("/appointments")
	public Appointment createEmployee(@Valid @RequestBody Appointment newappointments) {
		// Call the service to create a new appointment
		
		return service.createAppointment(newappointments);
	}
	// Endpoint to delete an appointment by ID
	@DeleteMapping("/appointments/{id}")
	public void deleteappointments(@PathVariable(value = "id")Integer appointmentsId){
		// Call the service to delete an appointment by ID
		service.deleteAppointment((long)appointmentsId);
	}
	// Endpoint to update an appointment by ID
	@PutMapping("/appointments/{id}")
	public void updateappointment(@PathVariable(value="id") Integer id, @Valid @RequestBody Appointment newappointments) {
		// Call the service to update an appointment by ID
		service.updateAppointment((long)id, newappointments);

	}
}

