package com.medical.management.service.impl;

import com.medical.management.dto.PatientCreateRequest;
import com.medical.management.dto.PatientResponse;
import com.medical.management.dto.PatientUpdateRequest;
import com.medical.management.entity.Patient;
import com.medical.management.exception.BadRequestException;
import com.medical.management.exception.NotFoundException;
import com.medical.management.repository.PatientRepository;
import com.medical.management.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repo;

    public PatientServiceImpl(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PatientResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public PatientResponse getById(Long id) {
        Patient p = repo.findById(id).orElseThrow(() -> new NotFoundException("Patient not found: " + id));
        return toResponse(p);
    }

    @Override
    @Transactional
    public PatientResponse create(PatientCreateRequest req) {
        if (repo.existsByNationalId(req.nationalId)) {
            throw new BadRequestException("nationalId already exists");
        }
        Patient p = new Patient(req.firstName, req.lastName, req.nationalId, req.phone);
        return toResponse(repo.save(p));
    }

    @Override
    @Transactional
    public PatientResponse update(Long id, PatientUpdateRequest req) {
        Patient p = repo.findById(id).orElseThrow(() -> new NotFoundException("Patient not found: " + id));
        p.setFirstName(req.firstName);
        p.setLastName(req.lastName);
        p.setPhone(req.phone);
        return toResponse(repo.save(p));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Patient not found: " + id);
        repo.deleteById(id);
    }

    private PatientResponse toResponse(Patient p) {
        PatientResponse r = new PatientResponse();
        r.id = p.getId();
        r.firstName = p.getFirstName();
        r.lastName = p.getLastName();
        r.nationalId = p.getNationalId();
        r.phone = p.getPhone();
        r.createdAt = p.getCreatedAt();
        return r;
    }
}
