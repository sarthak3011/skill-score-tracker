package com.fabhotel.skillEndorsment.processor.impl;
/**
 * @author: Sarthak Gupta
 * @description: SkillEvaluation class to check for deduction in points on the basis of skill closeness
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorProcessor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SkillEvaluation implements ScoreEvaluatorProcessor {
    @Override
    public ScoreValuatorCondition getCondition() {
        return ScoreValuatorCondition.SKILL_CLOSENESS;
    }

    @Override
    public String[] evaluateScore(EvaluateScoreDto evaluateScoreDto) {
        UserProfile reviewedUser = evaluateScoreDto.getReviewerUser();
        if (!reviewedUser.getSkills().contains(evaluateScoreDto.getSkillName())) {
            BigDecimal weighedScore = ScoreEvaluatorProcessor.findWeighedScoreAfterDeduction(evaluateScoreDto);
            return new String[]{String.valueOf(weighedScore), evaluateScoreDto.getEndorsedSkillCondition().getScoreAdjustmentReason()};
        }
        return new String[]{String.valueOf(evaluateScoreDto.getScore()), ""};
    }
}
