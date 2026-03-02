package com.medical.management.dto;

import java.time.Instant;

public class PatientResponse {
    public Long id;
    public String firstName;
    public String lastName;
    public String nationalId;
    public String phone;
    public Instant createdAt;
}
