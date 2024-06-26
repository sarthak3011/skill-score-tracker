package com.fabhotel.skillEndorsment.controller;
/**
 * @author: Sarthak Gupta
 * @description: Industry Controller class to get all industries
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.model.IndustryResponseDto;
import com.fabhotel.skillEndorsment.service.IndustryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/industry")
@RequiredArgsConstructor
public class IndustryController {

    private final IndustryService industryService;

    @GetMapping
    public List<IndustryResponseDto> findAllIndustries() {
        return industryService.getAllIndustries();
    }

    // OTHER CRUD's if required
}
