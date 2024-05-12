package com.fabhotel.skillEndorsment.converter;

import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.model.SkillsResponseDto;

public class SkillsConverter {

    public static SkillsResponseDto convertEntityToDto(Skills entity) {
        return SkillsResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .industry(IndustryConverter.convertEntityToDto(entity.getIndustry()))
                .build();
    }
}
