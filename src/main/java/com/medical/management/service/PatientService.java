package com.medical.management.service;

import com.medical.management.dto.PatientCreateRequest;
import com.medical.management.dto.PatientResponse;
import com.medical.management.dto.PatientUpdateRequest;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getAll();
    PatientResponse getById(Long id);
    PatientResponse create(PatientCreateRequest req);
    PatientResponse update(Long id, PatientUpdateRequest req);
    void delete(Long id);
}
