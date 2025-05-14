package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    void uploadDocument(Long candidateId, MultipartFile file, String type);
    void verifyDocument(Long candidateId, Long documentId);
}