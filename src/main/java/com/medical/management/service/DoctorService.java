package com.medical.management.service;

import com.medical.management.dto.DoctorCreateRequest;
import com.medical.management.dto.DoctorResponse;
import com.medical.management.dto.DoctorUpdateRequest;

import java.util.List;

public interface DoctorService {
    List<DoctorResponse> getAll();
    DoctorResponse getById(Long id);
    DoctorResponse create(DoctorCreateRequest req);
    DoctorResponse update(Long id, DoctorUpdateRequest req);
    void delete(Long id);
}
