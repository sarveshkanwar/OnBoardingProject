package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateStatus;
import com.example.demo.entity.OnboardingStatus;

public interface CandidateService {
    Candidate getCandidateById(Long id);
    List<Candidate> getHiredCandidates();
    Long getCandidateCount();
    void updateCandidateStatus(Long id, CandidateStatus status);
    void updateOnboardStatus(Long id, OnboardingStatus status);
}