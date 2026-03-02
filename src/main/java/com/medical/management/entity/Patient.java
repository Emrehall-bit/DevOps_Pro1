package com.medical.management.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "patients", indexes = {
        @Index(name = "idx_patients_national_id", columnList = "nationalId", unique = true)
})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String firstName;

    @Column(nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false, length = 20, unique = true)
    private String nationalId;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Patient() {}

    public Patient(String firstName, String lastName, String nationalId, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNationalId() { return nationalId; }
    public String getPhone() { return phone; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
