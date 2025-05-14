package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final JobOfferNotificationService notificationService;

    @PostMapping("/send-offer/{candidateId}")
    public ResponseEntity<Void> sendJobOfferEmail(@PathVariable Long candidateId) {
        notificationService.sendJobOfferEmail(candidateId);
        return ResponseEntity.ok().build();
    }
}
