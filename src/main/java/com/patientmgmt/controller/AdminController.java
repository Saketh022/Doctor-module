package com.patientmgmt.controller;



import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.patientmgmt.dto.DoctorDto;
import com.patientmgmt.dto.PatientDto;
import com.patientmgmt.entity.Doctor;
import com.patientmgmt.exception.ResourceNotFound;
import com.patientmgmt.service.DoctorService;
import com.patientmgmt.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;
    Logger logger = LogManager.getLogger(AdminController.class);
    @GetMapping(path = "/doctors", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Doctor> viewDoctorsList() throws ResourceNotFound {

        logger.info("viewing doctor list");
        List<Doctor> listdoctors = doctorService.getDoctors();
        logger.info("end of doctor list");
        if(listdoctors.isEmpty()){
            throw new ResourceNotFound("No Doctors are in the List");
        }else {
            return listdoctors;
        }
    }
    // Mapping for handling HTTP POST requests to create a new doctor

    @PostMapping("/doctors")
    public void createDoctor(@Valid @RequestBody Doctor doctorDto) {
        doctorService.addDoctor(doctorDto);
        logger.info("created doctor list succesfully");
    }

    // Mapping for handling HTTP GET requests to retrieve a list of patients
    @GetMapping(path = "/patients", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<PatientDto> viewPatientsList() throws ResourceNotFound {

        logger.info("**************viewing patients list****************");
        List<PatientDto> listpatients = patientService.getPatientFromDatabase();
        logger.info("***************end of patients list******************");
        if(listpatients.isEmpty()){
            throw new ResourceNotFound("No patients are in the List");
        }else {
            return listpatients;
        }
    }



}
