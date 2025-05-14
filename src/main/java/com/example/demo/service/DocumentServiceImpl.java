package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateDocument;
import com.example.demo.repository.CandidateDocumentRepository;
import com.example.demo.repository.CandidateRepository;

import jakarta.validation.Path;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final CandidateRepository candidateRepo;
    private final CandidateDocumentRepository docRepo;

    @Override
    public void uploadDocument(Long candidateId, MultipartFile file, String type) {
        Candidate candidate = candidateRepo.findById(candidateId)
            .orElseThrow(() -> new CandidateNotFoundException("Candidate not found"));

        String filePath = saveToLocal(file);

        CandidateDocument doc = CandidateDocument.builder()
            .candidate(candidate)
            .documentType(type)
            .fileUrl(filePath)
            .verified(false).build();

        docRepo.save(doc);
    }

    @Override
    public void verifyDocument(Long candidateId, Long documentId) {
        CandidateDocument doc = docRepo.findById(documentId)
            .orElseThrow(() -> new RuntimeException("Document not found"));
        if (!doc.getCandidate().getId().equals(candidateId)) {
            throw new RuntimeException("Document does not belong to candidate");
        }
        doc.setVerified(true);
        docRepo.save(doc);
    }

    private String saveToLocal(MultipartFile file) {
        try {
            Path path = Paths.get("uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename());
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            return path.toString();
        } catch (IOException e) {
            throw new RuntimeException("File upload failed", e);
        }
    }
}