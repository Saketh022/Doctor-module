package com.patientmgmt.dto;

import jakarta.validation.constraints.NotNull;

public class DoctorDto {
	@NotNull
	private int docId;
	@NotNull(message = "firstname should not be null")
	private String docFirstName;
	@NotNull(message = "firstname should not be null")
	private String docLastName;
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
	

}
