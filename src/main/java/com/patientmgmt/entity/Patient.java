package com.patientmgmt.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * Represents the Patient entity in the database.
 * The @Entity annotation indicates that instances of this class can be persisted to the database.
 * The @Table annotation specifies the name of the database table associated with this entity.
 */
@Entity
@Table(name="Patient")
public class Patient {
	// The @Id annotation marks this field as the primary key.
     // The @GeneratedValue annotation indicates that the value for this field will be automatically generated.
     //The strategy=GenerationType.AUTO specifies that the persistence provider should choose an appropriate strategy.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="patientId")
	private int patientId;
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="App_ID")
	//List<Appointment> app;
	@JoinColumn(name="Payment_ID")
	//List<Payments> payments;*/
	
	 //The @NotNull annotation indicates that this field must not be null.
	 // The @Column annotation specifies the name of the column in the database table.
	
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

    @OneToMany(mappedBy = "patient")
	private Set<Appointment> appointments;

//	public List<Appointment> getApps() {
//		return apps;
//	}
//
//	public void setApps(List<Appointment> apps) {
//		this.apps = apps;
//	}

	//parameterized const..
	public Patient(int patientId, String patientFirstName, String patientLastname, String patientAddress,
			String patientCity, String patientState) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastname;
		this.patientAddress = patientAddress;
		this.patientCity = patientCity;
		this.patientState = patientState;
	}
	//default const..
	public Patient() {
		super();
	}
	//getters & setters
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
	public void setPatientLastName(String patientLastname) {
		this.patientLastName = patientLastname;
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
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastname="
				+ patientLastName + ", patientAddress=" + patientAddress + ", patientCity=" + patientCity
				+ ", patientState=" + patientState + "]";
	}
	
	
	
	
}
