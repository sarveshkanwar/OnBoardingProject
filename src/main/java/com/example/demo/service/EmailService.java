package com.example.demo.service;

import com.example.demo.dto.CandidateDTO;

public interface EmailService {
    void sendOfferEmail(CandidateDTO dto);
}
