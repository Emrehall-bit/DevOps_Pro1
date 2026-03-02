package com.medical.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 80)
    private String clinic;

    public Doctor() {}

    public Doctor(String name, String clinic) {
        this.name = name;
        this.clinic = clinic;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getClinic() { return clinic; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setClinic(String clinic) { this.clinic = clinic; }
}
