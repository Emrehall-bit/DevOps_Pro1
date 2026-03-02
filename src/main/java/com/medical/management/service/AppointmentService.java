package com.medical.management.service;

import com.medical.management.dto.AppointmentCreateRequest;
import com.medical.management.dto.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponse> getAll();
    AppointmentResponse getById(Long id);
    AppointmentResponse create(AppointmentCreateRequest req);
    void delete(Long id);
}
