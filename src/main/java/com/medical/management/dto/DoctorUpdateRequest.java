package com.medical.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DoctorUpdateRequest {
    @NotBlank @Size(max = 80)
    public String name;

    @Size(max = 80)
    public String clinic;
}
