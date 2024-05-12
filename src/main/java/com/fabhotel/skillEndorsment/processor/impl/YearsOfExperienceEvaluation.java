package com.fabhotel.skillEndorsment.processor.impl;
/**
 * @author: Sarthak Gupta
 * @description: YearsOfExperienceEvaluation class to check for deduction in points on the basis of year of experience
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorProcessor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class YearsOfExperienceEvaluation implements ScoreEvaluatorProcessor {

    @Override
    public ScoreValuatorCondition getCondition() {
        return ScoreValuatorCondition.YEARS_OF_EXPERIENCE;
    }

    @Override
    public String[] evaluateScore(EvaluateScoreDto evaluateScoreDto) {
        if (evaluateScoreDto.getRevieweeUser().getYearsOfExperience() > evaluateScoreDto.getReviewerUser().getYearsOfExperience()) {
            BigDecimal deductedAmount = ScoreEvaluatorProcessor.findWeighedScoreAfterDeduction(evaluateScoreDto);
            return new String[]{String.valueOf(deductedAmount), evaluateScoreDto.getEndorsedSkillCondition().getScoreAdjustmentReason()};
        }
        return new String[]{String.valueOf(BigDecimal.ZERO), null};
    }
}
