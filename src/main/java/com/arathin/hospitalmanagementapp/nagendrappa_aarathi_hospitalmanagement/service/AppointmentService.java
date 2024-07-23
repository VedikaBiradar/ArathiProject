package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.Appointment;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
