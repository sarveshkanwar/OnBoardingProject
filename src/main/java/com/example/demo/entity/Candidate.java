package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private CandidateStatus status;

    @Enumerated(EnumType.STRING)
    private OnboardingStatus onboardStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CandidatePersonalInfo personalInfo;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CandidateBankInfo bankInfo;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CandidateEducation education;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<CandidateDocument> documents = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<JobOfferNotification> notifications = new ArrayList<>();
}