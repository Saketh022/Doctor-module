package com.patientmgmt.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.patientmgmt.entity.Doctor;
import com.patientmgmt.entity.Patient;
import com.patientmgmt.repository.DoctorRepository;
import com.patientmgmt.service.DoctorService;

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor1 = new Doctor(1,"sunil","shetty");
        Doctor doctor2 = new Doctor(2,"ranbir","kapoor");
        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);
        verify(doctorRepository, times(1)).save(doctor1);
        verify(doctorRepository, times(1)).save(doctor2);
    }

    @Test
    public void testGetDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        when(doctorRepository.findAll()).thenReturn(doctors);

        List<Doctor> result = doctorService.getDoctors();

        assertEquals(doctors, result);
    }

    @Test
    public void testGetDoctorById() {
        int doctorId = 34;
        Doctor doctor = new Doctor();
        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));

        Doctor result = doctorService.getDoctorById(doctorId);

        assertEquals(doctor, result);
    }

    @Test
    public void testUpdateDoctor() {
        int doctorId = 1;
        Doctor existingDoctor = new Doctor();
        existingDoctor.setDocFirstName("Saketh");
        existingDoctor.setDocLastName("Deshpande");
        Doctor newDoctor = new Doctor();
        newDoctor.setDocFirstName("Shaik");
        newDoctor.setDocLastName("Parvez");

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(existingDoctor));

        String result = doctorService.updateDoctor(doctorId, newDoctor);

        assertEquals("Doctor Updated", result);
        assertEquals("Shaik", existingDoctor.getDocFirstName());
        assertEquals("Parvez", existingDoctor.getDocLastName());
        verify(doctorRepository, times(1)).save(existingDoctor);
    }

    @Test
    public void testUpdateDoctor_NotFound() {
        int doctorId = 1;
        Doctor newDoctor = new Doctor();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        String result = doctorService.updateDoctor(doctorId, newDoctor);

        assertEquals("Doctor Not Updated", result);
        verify(doctorRepository, never()).save(any());
    }
}
