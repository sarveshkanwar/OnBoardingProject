package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidatePersonalInfoDTO {
    @NotNull private LocalDate dob;
    @NotBlank private String gender;
    @NotBlank private String address;
    @NotBlank private String nationality;
}