package com.patientmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmgmt.entity.Doctor;
import com.patientmgmt.exception.ResourceNotFound;
import com.patientmgmt.service.DoctorService;
import jakarta.validation.Valid;

@RestController
//Base path for all mapping annotations within this controller
@RequestMapping("/api")
public class DoctorController {
    // Logger for logging messages
    Logger logger = LogManager.getLogger(DoctorController.class);
    @Autowired
    private DoctorService doctorservice;
    
    // Mapping for handling HTTP GET requests to retrieve a list of doctors
    @GetMapping(path = "/doctors", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Doctor> viewDoctorsList() throws ResourceNotFound {

       logger.info("viewing doctor list");
       List<Doctor> listdoctors = doctorservice.getDoctors();
       logger.info("end of doctor list");
       if(listdoctors.isEmpty()){
          throw new ResourceNotFound("No Doctors are in the List");
       }else {
          return listdoctors;
       }
    }
    // Mapping for handling HTTP POST requests to create a new doctor
    @PostMapping("/doctors")
    public void createDoctor(@Valid @RequestBody Doctor doctor) {
       doctorservice.addDoctor(doctor);
       logger.info("created doctor list succesfully");
    }
    // Mapping for handling HTTP GET requests to retrieve a specific doctor by ID
    	@GetMapping("/doctors/{d_id}")
    	public Doctor findByDoctor(@PathVariable(value="d_id") int d_id) throws ResourceNotFound {
    	       try {
    	          return doctorservice.getDoctorById(d_id);
    	       } catch (Exception e) {
    	            throw new ResourceNotFound("Doctor Not Found");
    	        }
    	    }
    // Mapping for handling HTTP PUT requests to update an existing doctor
    @PutMapping("/doctors/{id}")
    public String updateDoctor(@PathVariable(value="id") int id, @Valid @RequestBody Doctor newDoctor) {
        return doctorservice.updateDoctor(id, newDoctor);
    }
}