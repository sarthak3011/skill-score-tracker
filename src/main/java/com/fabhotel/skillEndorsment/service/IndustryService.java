package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.entity.Industry;
import com.fabhotel.skillEndorsment.model.IndustryResponseDto;

import java.util.List;

public interface IndustryService {
    List<IndustryResponseDto> getAllIndustries();

    Industry getIndustry(Long id);
}
