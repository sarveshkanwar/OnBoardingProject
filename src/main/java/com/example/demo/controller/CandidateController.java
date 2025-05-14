package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateStatus;
import com.example.demo.entity.OnboardingStatus;
import com.example.demo.service.CandidateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/hired")
    public ResponseEntity<List<Candidate>> getHiredCandidates() {
        return ResponseEntity.ok(candidateService.getHiredCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getCandidateById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCandidateCount() {
        return ResponseEntity.ok(candidateService.getCandidateCount());
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id,
                                             @RequestParam CandidateStatus status) {
        candidateService.updateCandidateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/onboard-status")
    public ResponseEntity<Void> updateOnboardStatus(@PathVariable Long id,
                                                    @RequestParam OnboardingStatus status) {
        candidateService.updateOnboardStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
