package com.medical.management.service.impl;

import com.medical.management.dto.DoctorCreateRequest;
import com.medical.management.dto.DoctorResponse;
import com.medical.management.dto.DoctorUpdateRequest;
import com.medical.management.entity.Doctor;
import com.medical.management.exception.NotFoundException;
import com.medical.management.repository.DoctorRepository;
import com.medical.management.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repo;

    public DoctorServiceImpl(DoctorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<DoctorResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public DoctorResponse getById(Long id) {
        Doctor d = repo.findById(id).orElseThrow(() -> new NotFoundException("Doctor not found: " + id));
        return toResponse(d);
    }

    @Override
    @Transactional
    public DoctorResponse create(DoctorCreateRequest req) {
        Doctor d = new Doctor(req.name, req.clinic);
        return toResponse(repo.save(d));
    }

    @Override
    @Transactional
    public DoctorResponse update(Long id, DoctorUpdateRequest req) {
        Doctor d = repo.findById(id).orElseThrow(() -> new NotFoundException("Doctor not found: " + id));
        d.setName(req.name);
        d.setClinic(req.clinic);
        return toResponse(repo.save(d));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Doctor not found: " + id);
        repo.deleteById(id);
    }

    private DoctorResponse toResponse(Doctor d) {
        DoctorResponse r = new DoctorResponse();
        r.id = d.getId();
        r.name = d.getName();
        r.clinic = d.getClinic();
        return r;
    }
}
