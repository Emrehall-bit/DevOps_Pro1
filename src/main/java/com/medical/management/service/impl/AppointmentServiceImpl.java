package com.medical.management.service.impl;

import com.medical.management.dto.AppointmentCreateRequest;
import com.medical.management.dto.AppointmentResponse;
import com.medical.management.entity.Appointment;
import com.medical.management.entity.Doctor;
import com.medical.management.entity.Patient;
import com.medical.management.exception.NotFoundException;
import com.medical.management.repository.AppointmentRepository;
import com.medical.management.repository.DoctorRepository;
import com.medical.management.repository.PatientRepository;
import com.medical.management.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository apptRepo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    public AppointmentServiceImpl(AppointmentRepository apptRepo, PatientRepository patientRepo, DoctorRepository doctorRepo) {
        this.apptRepo = apptRepo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public List<AppointmentResponse> getAll() {
        return apptRepo.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public AppointmentResponse getById(Long id) {
        Appointment a = apptRepo.findById(id).orElseThrow(() -> new NotFoundException("Appointment not found: " + id));
        return toResponse(a);
    }

    @Override
    @Transactional
    public AppointmentResponse create(AppointmentCreateRequest req) {
        Patient p = patientRepo.findById(req.patientId)
                .orElseThrow(() -> new NotFoundException("Patient not found: " + req.patientId));
        Doctor d = doctorRepo.findById(req.doctorId)
                .orElseThrow(() -> new NotFoundException("Doctor not found: " + req.doctorId));

        Appointment a = new Appointment(p, d, req.appDate, req.appTime, req.reason);
        return toResponse(apptRepo.save(a));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!apptRepo.existsById(id)) throw new NotFoundException("Appointment not found: " + id);
        apptRepo.deleteById(id);
    }

    private AppointmentResponse toResponse(Appointment a) {
        AppointmentResponse r = new AppointmentResponse();
        r.id = a.getId();
        r.patientId = a.getPatient().getId();
        r.doctorId = a.getDoctor().getId();
        r.appDate = a.getAppDate();
        r.appTime = a.getAppTime();
        r.reason = a.getReason();
        return r;
    }
}
