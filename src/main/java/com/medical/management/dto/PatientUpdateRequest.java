package com.medical.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientUpdateRequest {
    @NotBlank @Size(max = 80)
    public String firstName;

    @NotBlank @Size(max = 80)
    public String lastName;

    @Size(max = 20)
    public String phone;
}
