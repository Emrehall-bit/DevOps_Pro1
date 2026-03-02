package com.medical.management.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponse {
    public Long id;
    public Long patientId;
    public Long doctorId;
    public LocalDate appDate;
    public LocalTime appTime;
    public String reason;
}
