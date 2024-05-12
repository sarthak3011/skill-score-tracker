package com.fabhotel.skillEndorsment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillsResponseDto {

    private Long id;
    private String name;
    private String description;
    private IndustryResponseDto industry;
}
