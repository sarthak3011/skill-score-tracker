package com.fabhotel.skillEndorsment.service.impl;
/**
 * @author: Sarthak Gupta
 * @description: Skill service class for basic CRUD business logic
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.converter.SkillsConverter;
import com.fabhotel.skillEndorsment.entity.Industry;
import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.model.SkillsResponseDto;
import com.fabhotel.skillEndorsment.repository.SkillsRepo;
import com.fabhotel.skillEndorsment.service.IndustryService;
import com.fabhotel.skillEndorsment.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final IndustryService industryService;

    private final SkillsRepo skillsRepo;

    @Override
    public List<SkillsResponseDto> getAllSkillsByIndustry(Long industryId) throws RuntimeException {
        Industry industry = industryService.getIndustry(industryId);
        if (Objects.isNull(industry)) {
            log.error("[getAllSkillsByIndustry] Industry doesn't exist : {}", industryId);
            throw new RuntimeException("Industry doesn't exist");
        }
        List<Skills> skillByIndustry = skillsRepo.findByIndustry(industry);
        return skillByIndustry.stream().map(skills -> SkillsConverter.convertEntityToDto(skills)).toList();
    }

    @Override
    public Skills getSkillById(Long id) throws RuntimeException {
        return skillsRepo.findById(id).orElseThrow(() -> new RuntimeException("Skill not present"));
    }

}
