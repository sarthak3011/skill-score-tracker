package com.fabhotel.skillEndorsment.service.impl;
/**
 * @author: Sarthak Gupta
 * @description: Industry service class for basic CRUD business logic
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.converter.IndustryConverter;
import com.fabhotel.skillEndorsment.entity.Industry;
import com.fabhotel.skillEndorsment.model.IndustryResponseDto;
import com.fabhotel.skillEndorsment.repository.IndustryRepo;
import com.fabhotel.skillEndorsment.service.IndustryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class IndustryServiceImpl implements IndustryService {

    private final IndustryRepo industryRepo;

    @Override
    public List<IndustryResponseDto> getAllIndustries() {
        List<Industry> allIndustries = industryRepo.findAll();
        return allIndustries
                .stream().map(industry -> IndustryConverter.convertEntityToDto(industry))
                .collect(Collectors.toList());
    }

    @Override
    public Industry getIndustry(Long id) {
        return industryRepo.findById(id).orElse(null);
    }
}
