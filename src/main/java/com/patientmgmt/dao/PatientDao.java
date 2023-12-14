package com.patientmgmt.dao;

import java.util.List;
import java.util.Optional;

import com.patientmgmt.dto.PatientDto;



public interface PatientDao {
	
	public PatientDto getPatient(int patientId);
	public List<PatientDto> getPatientFromDatabase();
//	public List<PatientDto> listAll();
	public void createPatient(PatientDto patientDto);
	public String updatePatient(Integer patientId, PatientDto newPatientDto);
	

}
