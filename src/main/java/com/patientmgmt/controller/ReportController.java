package com.patientmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmgmt.entity.Appointment;
import com.patientmgmt.repository.AppointmentRepository;
import com.patientmgmt.service.AppointmentService;
import com.patientmgmt.service.PatientService;



@RestController
@RequestMapping("/api")
public class ReportController {
	//Stream api operations
	@Autowired
	PatientService service;
	
    
    @Autowired
    AppointmentService appservice;
    
	AppointmentRepository appointmentRepository;
//	//PaymentService service;
//		@GetMapping("/patients/viewLocation")
//	    public List<PatientDto> getPatientsByLocation() {
//	        // Retrieve all patients
//	        List<PatientDto> allPatients = service.getPatientFromDatabase();
//	 
//	        // Use Stream API to filter and sort patients by state
//	        List<PatientDto> filteredAndSortedPatients = allPatients.stream()
//	                .filter(patient -> patient.getPatientState() != null && !patient.getPatientState().isEmpty())
//	                .sorted(Comparator.comparing(PatientDto::getPatientState))
//	                .collect(Collectors.toList());
//	 
//	        return filteredAndSortedPatients;
//	    }                                                  //written by kanaka durga
		

		// Mapping for handling HTTP GET requests to retrieve the number of appointments for a specific doctor
	    @GetMapping("/doctor/{id}/appointments/noOfAppointments")
	    public long getNumberOfAppointments(@PathVariable int id) {
	        List<Appointment> appointments = (List<Appointment>) appointmentRepository;
	 
	        // Use the Stream API to count appointments
	        long numberOfAppointments = appointments.stream().count();
	 
	        return numberOfAppointments;
	    }                                                         //written by Saketh Deshpande
		
	    
//	    @GetMapping(path="/bill/listbills")
//	    public Map<LocalDate, Long> viewBillList() throws ResourceNotFound {
//	       
//	        List<BillDto> listBills = billservice.getBillFromDatabase();
//	        if (listBills.isEmpty()) {
//	            throw new ResourceNotFound("No bills are in the list");
//	        } else {
//	            // Use Stream API to group bills by LocalDate and count the occurrences
//	            return listBills.stream()
//	                .collect(Collectors.groupingBy(BillDto::getBillDate, Collectors.counting()));
//	        }
//	    }                                          //written by Pujitha Anishetty
	    
//	    @GetMapping(path = "/payments/highestPayment")
//		public PaymentDto viewHighestPayment() throws ResourceNotFound {
//	 
//		    List<PaymentDto> listpayments = paymentservice.getPaymentsFromDatabase();
//		    for(PaymentDto paymentDto:listpayments){
//		       System.out.println(paymentDto.getPayAmount());
//		    }
//		    Optional<PaymentDto> maxPayment = listpayments.stream().collect(Collectors.maxBy( (p1, p2)-> (int) (p1.getPayAmount()-p2.getPayAmount() )));
//		    System.out.println(maxPayment.get().getPayAmount());
//		    return maxPayment.get();
//		}                                             //written by Prasanthi Krishnamoorthy
		
		
//	    @GetMapping("/appointmentsByDate")
//		public List<AppointmentDto> viewAppointmentDtos() throws ResourceNotFound {
//	 
//		    // Retrieve the list of appointments from the service
//		    List<AppointmentDto> listAppointments = appservice.getAppointmentsFromDatabase();
//	 
//		    if (listAppointments.isEmpty()) {
//		        throw new ResourceNotFound("No Appointments are in the List");
//		    } else {
//		        // Use Stream API to filter appointments based on LocalDate
//		        List<AppointmentDto> filteredAppointments = listAppointments.stream()
//		                .filter(appointment -> appointment.getDate().isAfter(LocalDate.parse("2023-10-20")))
//		                .collect(Collectors.toList());
//	 
//		        // Return the filtered list of appointments
//		        return filteredAppointments;
//		    }
		}                                                //written by Bharath Gaddam
