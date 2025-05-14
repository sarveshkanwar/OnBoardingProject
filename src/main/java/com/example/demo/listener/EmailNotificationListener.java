package com.example.demo.listener;

import com.example.demo.dto.CandidateDTO;
import com.example.demo.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailNotificationListener {

    private final EmailService emailService;
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void handleJobOfferEmail(CandidateDTO dto) {
        log.info("📥 Received job offer notification for candidate: {}", dto.getEmail());
        try {
            emailService.sendOfferEmail(dto);
            log.info("📧 Email successfully sent to: {}", dto.getEmail());
        } catch (Exception ex) {
            log.error("❌ Failed to send email to {}: {}", dto.getEmail(), ex.getMessage());
            // Retry logic or dead-letter queue can be handled here
        }
    }
} 