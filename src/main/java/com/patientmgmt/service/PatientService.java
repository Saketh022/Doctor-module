package com.patientmgmt.service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmgmt.dao.PatientDao;
import com.patientmgmt.dto.PatientDto;
import com.patientmgmt.entity.Patient;
import com.patientmgmt.repository.PatientRepository;


@Service
// This class contains methods for retrieving patient information from the database.
public class PatientService implements PatientDao {
	 // Autowired annotation is used for automatic dependency injection of PatientRepository.
	@Autowired
	 private PatientRepository patientRepo;
	@Autowired
    private ModelMapper modelMapper;
	public PatientDto getPatient(int patientId){
		// Retrieve the patient from the database using the patientId with patientRepo.findById()

		Optional<Patient> p=patientRepo.findById(patientId);
		PatientDto patientDto = mapToDto(p.get());
		return patientDto;
	}
	public List<PatientDto> getPatientFromDatabase(){
		// Retrieve all patients from the database using patientRepo.findAll()
		List<Patient> patients = patientRepo.findAll();
		List<PatientDto> patientDtos = patients.stream().map(this::mapToDto).collect(Collectors.toList());

		return patientDtos;
	}
//	public List<PatientDto> listAll(){
//		// Retrieve all patients from the database using patientRepo.findAll()
//		List<Patient> patients=patientRepo.findAll();
//		// Print the list of patients to the console
//		System.out.println(patients);
//	    // Return the list of patients
//
//		return patients;
//	}
	public void createPatient(PatientDto patientDto) {   //creation of patient
		// Save the new patient information to the database using patientRepo.save()
		Patient patient = mapToEntity(patientDto);
		 patientRepo.save(patient);
	}
	/*public Map<String,Boolean> deletePatient(Integer patientId){               //delete a patient

		patientRepo.deleteById(patientId);
		Map<String,Boolean> response=new HashMap<>();
		response.put("patient has been deleted", Boolean.TRUE);
		return response;
	}*/	
	//update existing patient
	public String updatePatient(Integer patientId, PatientDto newPatientDto) {
		// Retrieve the existing patient from the database based on patientId
		Optional<Patient> existingPatient =patientRepo.findById(patientId);
		// Check if the patient with the given patientId exists
		if(existingPatient.isPresent()) {
			// If the patient exists, update their information with the newPatient data
			Patient foundPatient = existingPatient.get();
			foundPatient.setPatientFirstName(newPatientDto.getPatientFirstName());
			foundPatient.setPatientLastName(newPatientDto.getPatientLastName());
			foundPatient.setPatientAddress(newPatientDto.getPatientAddress());
			foundPatient.setPatientCity(newPatientDto.getPatientCity());
			foundPatient.setPatientState(newPatientDto.getPatientState());
			// Save the updated patient information to the database
			patientRepo.save(foundPatient);
			// Return a success message
			return "Patient Updated";
		}
		// If the patient is not found, return a message indicating no updates were performed
		return "Patient Not Updated";

	}
	 public PatientDto mapToDto(Patient idto)
	    {return modelMapper.map(idto, PatientDto.class);}
	  
	    public Patient mapToEntity(PatientDto idto)
	    {
	 
	    	return modelMapper.map(idto, Patient.class);
	    	
	    }

}
