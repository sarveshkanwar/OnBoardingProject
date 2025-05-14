package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateBankInfoDTO {
    @NotBlank private String bankName;
    @NotBlank private String accountNumber;
    @NotBlank private String ifscCode;
}