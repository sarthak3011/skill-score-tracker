package com.fabhotel.skillEndorsment.controller;

import com.fabhotel.skillEndorsment.model.SkillsResponseDto;
import com.fabhotel.skillEndorsment.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skill")
@RequiredArgsConstructor
public class SkillsController {

    private final SkillService skillService;

    @GetMapping
    public List<SkillsResponseDto> getAllSkillsByIndustry(@RequestParam Long industryId) {
        return skillService.getAllSkillsByIndustry(industryId);
    }
}
