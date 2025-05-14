package com.example.demo.util;

import com.example.demo.dto.CandidateBankInfoDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.dto.CandidateEducationDTO;
import com.example.demo.dto.CandidatePersonalInfoDTO;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateBankInfo;
import com.example.demo.entity.CandidateEducation;
import com.example.demo.entity.CandidatePersonalInfo;

public class DTOMapper {

    public static CandidateDTO toDTO(Candidate candidate) {
        return CandidateDTO.builder()
                .id(candidate.getId())
                .firstName(candidate.getFirstName())
                .email(candidate.getEmail())
                .build();
    }

    public static CandidatePersonalInfo toEntity(CandidatePersonalInfoDTO dto, Candidate candidate) {
        return CandidatePersonalInfo.builder()
                .dob(dto.getDob())
                .gender(dto.getGender())
                .address(dto.getAddress())
                .nationality(dto.getNationality())
                .candidate(candidate)
                .build();
    }

    public static CandidateBankInfo toEntity(CandidateBankInfoDTO dto, Candidate candidate) {
        return CandidateBankInfo.builder()
                .bankName(dto.getBankName())
                .accountNumber(dto.getAccountNumber())
                .ifscCode(dto.getIfscCode())
                .candidate(candidate)
                .build();
    }

    public static CandidateEducation toEntity(CandidateEducationDTO dto, Candidate candidate) {
        return CandidateEducation.builder()
                .degree(dto.getDegree())
                .institution(dto.getInstitution())
                .yearOfPassing(dto.getYearOfPassing())
                .candidate(candidate)
                .build();
    }
}