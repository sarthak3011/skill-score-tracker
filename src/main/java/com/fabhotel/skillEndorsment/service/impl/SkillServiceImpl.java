package com.fabhotel.skillEndorsment.service.impl;

import com.fabhotel.skillEndorsment.converter.SkillsConverter;
import com.fabhotel.skillEndorsment.entity.Industry;
import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.model.SkillsResponseDto;
import com.fabhotel.skillEndorsment.repository.SkillsRepo;
import com.fabhotel.skillEndorsment.service.IndustryService;
import com.fabhotel.skillEndorsment.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
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
    public List<SkillsResponseDto> getAllSkillsByIndustry(Long industryId) throws BadRequestException {
        Industry industry = industryService.getIndustry(industryId);
        if (Objects.isNull(industry)) {
            log.error("[getAllSkillsByIndustry] Industry doesn't exist : {}", industryId);
            throw new BadRequestException("Industry doesn't exist");
        }
        List<Skills> skillByIndustry = skillsRepo.findByIndustry(industry);
        return skillByIndustry.stream().map(skills -> SkillsConverter.convertEntityToDto(skills)).toList();
    }
}
