package com.patientmgmt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public class PatientDto {
	
	@Id
	private int id;
	@NotEmpty (message="Patient firstname should not be empty")
	@Column(name="patientFirstName")
	private String patientFirstName ;
	@NotEmpty(message="Patient lastname should not be empty")
	@Column(name="patientLastName")
	private String patientLastName;
	@NotEmpty (message="Patient address should not be empty")
	@Column(name="patientAddress")
	private String patientAddress;
	@NotEmpty (message="Patient city should not be empty")
	@Column(name="patientCity")
	private String patientCity;
	@NotEmpty(message="Patient state should not be empty")
	@Column(name="patientState")
	private String patientState;
	public PatientDto(int id, @NotEmpty(message = "Patient firstname should not be empty") String patientFirstName,
			@NotEmpty(message = "Patient lastname should not be empty") String patientLastName,
			@NotEmpty(message = "Patient address should not be empty") String patientAddress,
			@NotEmpty(message = "Patient city should not be empty") String patientCity,
			@NotEmpty(message = "Patient state should not be empty") String patientState) {
		super();
		this.id = id;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientAddress = patientAddress;
		this.patientCity = patientCity;
		this.patientState = patientState;
	}

	public PatientDto() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientCity() {
		return patientCity;
	}
	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}
	public String getPatientState() {
		return patientState;
	}
	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}
	

}
