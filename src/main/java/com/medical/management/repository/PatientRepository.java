package com.medical.management.repository;

import com.medical.management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByNationalId(String nationalId);
}
