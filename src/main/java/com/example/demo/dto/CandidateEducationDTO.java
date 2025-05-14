package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateEducationDTO {
    @NotBlank private String degree;
    @NotBlank private String institution;
    @NotNull private Integer yearOfPassing;
}