package com.patientmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientmgmt.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
