package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateStatus;
import com.example.demo.entity.OnboardingStatus;
import com.example.demo.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
            .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
    }

    @Override
    public List<Candidate> getHiredCandidates() {
        return candidateRepository.findByStatus(CandidateStatus.OFFERED);
    }

    @Override
    public Long getCandidateCount() {
        return candidateRepository.count();
    }

    @Override
    public void updateCandidateStatus(Long id, CandidateStatus status) {
        Candidate candidate = getCandidateById(id);
        candidate.setStatus(status);
        candidateRepository.save(candidate);
    }

    @Override
    public void updateOnboardStatus(Long id, OnboardingStatus status) {
        Candidate candidate = getCandidateById(id);
        candidate.setOnboardStatus(status);
        candidateRepository.save(candidate);
    }
}
