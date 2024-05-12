package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.model.SkillsResponseDto;

import java.util.List;

public interface SkillService {

    List<SkillsResponseDto> getAllSkillsByIndustry(Long industryId) throws RuntimeException;

    Skills getSkillById(Long id) throws RuntimeException;
}
