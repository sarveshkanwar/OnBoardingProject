package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CandidateBankInfoDTO;
import com.example.demo.dto.CandidateEducationDTO;
import com.example.demo.dto.CandidatePersonalInfoDTO;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateBankInfo;
import com.example.demo.entity.CandidateEducation;
import com.example.demo.entity.CandidatePersonalInfo;
import com.example.demo.repository.CandidateBankInfoRepository;
import com.example.demo.repository.CandidateEducationRepository;
import com.example.demo.repository.CandidatePersonalInfoRepository;
import com.example.demo.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateInfoServiceImpl implements CandidateInfoService {

    private final CandidateRepository candidateRepo;
    private final CandidatePersonalInfoRepository personalRepo;
    private final CandidateBankInfoRepository bankRepo;
    private final CandidateEducationRepository educationRepo;

    @Override
    public void updatePersonalInfo(Long candidateId, CandidatePersonalInfoDTO dto) {
        Candidate candidate = getCandidate(candidateId);
        CandidatePersonalInfo info = CandidatePersonalInfo.builder()
            .dob(dto.getDob())
            .gender(dto.getGender())
            .address(dto.getAddress())
            .nationality(dto.getNationality())
            .candidate(candidate).build();
        personalRepo.save(info);
    }

    @Override
    public void updateBankInfo(Long candidateId, CandidateBankInfoDTO dto) {
        Candidate candidate = getCandidate(candidateId);
        CandidateBankInfo info = CandidateBankInfo.builder()
            .bankName(dto.getBankName())
            .accountNumber(dto.getAccountNumber())
            .ifscCode(dto.getIfscCode())
            .candidate(candidate).build();
        bankRepo.save(info);
    }

    @Override
    public void updateEducationInfo(Long candidateId, CandidateEducationDTO dto) {
        Candidate candidate = getCandidate(candidateId);
        CandidateEducation info = CandidateEducation.builder()
            .degree(dto.getDegree())
            .institution(dto.getInstitution())
            .yearOfPassing(dto.getYearOfPassing())
            .candidate(candidate).build();
        educationRepo.save(info);
    }

    private Candidate getCandidate(Long id) {
        return candidateRepo.findById(id)
            .orElseThrow(() -> new CandidateNotFoundException("Candidate not found: " + id));
    }
}
