package com.medical.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentCreateRequest {
    @NotNull
    public Long patientId;

    @NotNull
    public Long doctorId;

    @NotNull
    public LocalDate appDate;

    @NotNull
    public LocalTime appTime;

    @NotBlank
    public String reason;
}
