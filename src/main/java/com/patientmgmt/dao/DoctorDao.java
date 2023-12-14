package com.patientmgmt.dao;

import java.util.List;

import com.patientmgmt.entity.Doctor;

public interface DoctorDao {
	public void addDoctor(Doctor doctor);
	 public List<Doctor> getDoctors();
	 public Doctor getDoctorById(int doctorId);
	 public String updateDoctor(Integer doctorId, Doctor newDoctor);


}
