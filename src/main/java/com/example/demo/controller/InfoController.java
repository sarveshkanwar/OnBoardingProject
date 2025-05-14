package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/candidates/{id}")
@RequiredArgsConstructor
public class InfoController {

    private final CandidateInfoService infoService;

    @PutMapping("/personal-info")
    public ResponseEntity<Void> updatePersonalInfo(@PathVariable Long id,
                                                   @RequestBody @Valid CandidatePersonalInfoDTO dto) {
        infoService.updatePersonalInfo(id, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/bank-info")
    public ResponseEntity<Void> updateBankInfo(@PathVariable Long id,
                                               @RequestBody @Valid CandidateBankInfoDTO dto) {
        infoService.updateBankInfo(id, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/educational-info")
    public ResponseEntity<Void> updateEducationInfo(@PathVariable Long id,
                                                    @RequestBody @Valid CandidateEducationDTO dto) {
        infoService.updateEducationInfo(id, dto);
        return ResponseEntity.ok().build();
    }
}
