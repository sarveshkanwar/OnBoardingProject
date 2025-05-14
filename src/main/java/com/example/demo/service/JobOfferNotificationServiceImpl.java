package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CandidateDTO;
import com.example.demo.entity.Candidate;
import com.example.demo.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobOfferNotificationServiceImpl implements JobOfferNotificationService {

    private final CandidateRepository candidateRepo;
    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}") private String exchange;
    @Value("${rabbitmq.routingKey}") private String routingKey;

    @Override
    public void sendJobOfferEmail(Long candidateId) {
        Candidate candidate = candidateRepo.findById(candidateId)
            .orElseThrow(() -> new CandidateNotFoundException("Candidate not found"));

        CandidateDTO dto = CandidateDTO.builder()
            .id(candidate.getId())
            .firstName(candidate.getFirstName())
            .email(candidate.getEmail())
            .build();

        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
