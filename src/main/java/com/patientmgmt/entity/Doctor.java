package com.patientmgmt.entity;

import java.util.List;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@NotNull
	private int docId;
	@NotNull(message = "firstname should not be null")
	private String docFirstName;
	@NotNull(message = "firstname should not be null")
	private String docLastName;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "doctor")
	private Set<Appointment> appointments;

	//default Constructor	
	public Doctor() {
		
	}
	//Parameterized Constructor
	public Doctor(int docId, String docFirstName, String docLastName) {
		super();
		this.docId = docId;
		this.docFirstName = docFirstName;
		this.docLastName = docLastName;
	}
	//implement getters and setters for properties 
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocFirstName() {
		return docFirstName;
	}
	public void setDocFirstName(String docFirstName) {
		this.docFirstName = docFirstName;
	}
	public String getDocLastName() {
		return docLastName;
	}
	public void setDocLastName(String docLastName) {
		this.docLastName = docLastName;
	}

	

//	public List<Appointment> getApps() {
//		return apps;
//	}
//
//	public void setApps(List<Appointment> apps) {
//		this.apps = apps;
//	}

	//toString method 
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docFirstName=" + docFirstName + ", docLastName=" + docLastName + "]";
	}

}

