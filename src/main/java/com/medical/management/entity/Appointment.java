package com.medical.management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments", uniqueConstraints = {
        @UniqueConstraint(name = "uk_doctor_date_time", columnNames = {"doctor_id", "app_date", "app_time"})
})
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "app_date", nullable = false)
    private LocalDate appDate;

    @Column(name = "app_time", nullable = false)
    private LocalTime appTime;

    @Column(nullable = false, length = 200)
    private String reason;

    public Appointment() {}

    public Appointment(Patient patient, Doctor doctor, LocalDate appDate, LocalTime appTime, String reason) {
        this.patient = patient;
        this.doctor = doctor;
        this.appDate = appDate;
        this.appTime = appTime;
        this.reason = reason;
    }

    public Long getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDate getAppDate() { return appDate; }
    public LocalTime getAppTime() { return appTime; }
    public String getReason() { return reason; }

    public void setId(Long id) { this.id = id; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setAppDate(LocalDate appDate) { this.appDate = appDate; }
    public void setAppTime(LocalTime appTime) { this.appTime = appTime; }
    public void setReason(String reason) { this.reason = reason; }
}
