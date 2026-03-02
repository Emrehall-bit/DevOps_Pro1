package com.medical.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientCreateRequest {
    @NotBlank @Size(max = 80)
    public String firstName;

    @NotBlank @Size(max = 80)
    public String lastName;

    @NotBlank
    @Pattern(regexp = "^[0-9]{6,20}$", message = "nationalId must be numeric and 6-20 digits")
    public String nationalId;

    @Size(max = 20)
    public String phone;
}
