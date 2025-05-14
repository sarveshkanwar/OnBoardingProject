package com.example.demo.service;

import com.example.demo.dto.CandidateBankInfoDTO;
import com.example.demo.dto.CandidateEducationDTO;
import com.example.demo.dto.CandidatePersonalInfoDTO;

public interface CandidateInfoService {
    void updatePersonalInfo(Long candidateId, CandidatePersonalInfoDTO dto);
    void updateBankInfo(Long candidateId, CandidateBankInfoDTO dto);
    void updateEducationInfo(Long candidateId, CandidateEducationDTO dto);
}