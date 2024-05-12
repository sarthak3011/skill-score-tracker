package com.fabhotel.skillEndorsment.processor.impl;
/**
 * @author: Sarthak Gupta
 * @description: CoworkerEvaluation class to check for deduction in points on the basis of coworker status
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorProcessor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CoworkerEvaluation implements ScoreEvaluatorProcessor {

    @Override
    public ScoreValuatorCondition getCondition() {
        return ScoreValuatorCondition.COWORKER_STATUS;
    }

    @Override
    public String[] evaluateScore(EvaluateScoreDto evaluateScoreDto) {
        List<String> reviewedUserCompanies = evaluateScoreDto.getReviewerUser().getCompanies();
        List<String> revieweeUserCompanies = evaluateScoreDto.getRevieweeUser().getCompanies();

        boolean doesCompanyMatch = reviewedUserCompanies.stream()
                .anyMatch(revieweeUserCompanies::contains);
        if (!doesCompanyMatch) {
            BigDecimal weighedScore = ScoreEvaluatorProcessor.findWeighedScoreAfterDeduction(evaluateScoreDto);
            return new String[]{String.valueOf(weighedScore), evaluateScoreDto.getEndorsedSkillCondition().getScoreAdjustmentReason()};
        }
        return new String[]{String.valueOf(evaluateScoreDto.getScore()), ""};
    }
}
