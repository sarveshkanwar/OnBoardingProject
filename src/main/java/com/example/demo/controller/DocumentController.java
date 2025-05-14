package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.DocumentService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/documents")
@NoArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/{candidateId}/upload")
    public ResponseEntity<Void> uploadDocument(@PathVariable Long candidateId,
                                               @RequestParam("file") MultipartFile file,
                                               @RequestParam("type") String documentType) {
        documentService.uploadDocument(candidateId, file, documentType);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{candidateId}/verify")
    public ResponseEntity<Void> verifyDocument(@PathVariable Long candidateId,
                                               @RequestParam("documentId") Long documentId) {
        documentService.verifyDocument(candidateId, documentId);
        return ResponseEntity.ok().build();
    }
}
