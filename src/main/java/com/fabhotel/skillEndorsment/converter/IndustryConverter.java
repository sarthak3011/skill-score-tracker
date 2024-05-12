package com.fabhotel.skillEndorsment.converter;

import com.fabhotel.skillEndorsment.entity.Industry;
import com.fabhotel.skillEndorsment.model.IndustryResponseDto;

public class IndustryConverter {

    public static IndustryResponseDto convertEntityToDto(Industry entity) {
        return IndustryResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
