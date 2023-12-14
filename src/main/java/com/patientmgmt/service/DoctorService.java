package com.patientmgmt.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmgmt.dao.DoctorDao;
import com.patientmgmt.dto.DoctorDto;
import com.patientmgmt.entity.Doctor;
import com.patientmgmt.repository.DoctorRepository;

@Service
public class DoctorService implements DoctorDao {
	
	@Autowired
	// Private instance variable for DoctorRepository
	private DoctorRepository doctorRepository ;
	
	@Autowired
    private ModelMapper modelMapper;
	
	// Method to add a new doctor to the repository
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    // Method to retrieve a list of all doctors from the repository
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }
    // Method to retrieve a specific doctor by their ID from the repository
    public Doctor getDoctorById(int doctorId) {
    	return doctorRepository.findById(doctorId).get();
        
    }
    // Method to update an existing doctor in the repository
    public String updateDoctor(Integer doctorId, Doctor newDoctor) {
		Optional<Doctor> existingDoctor =doctorRepository.findById(doctorId);
		if(existingDoctor.isPresent()) {
			Doctor foundDoctor = existingDoctor.get();
			foundDoctor.setDocFirstName(newDoctor.getDocFirstName());
			foundDoctor.setDocLastName(newDoctor.getDocLastName());
			doctorRepository.save(foundDoctor);
			return "Doctor Updated";
		}
		return "Doctor Not Updated";
 
	}
    public DoctorDto mapToDto(Doctor idto)
    {
  	
    	return modelMapper.map(idto, DoctorDto.class);
    	
    }
  
    public Doctor mapToEntity(DoctorDto idto)
    {
 
    	return modelMapper.map(idto, Doctor.class);
    	
    }
}
