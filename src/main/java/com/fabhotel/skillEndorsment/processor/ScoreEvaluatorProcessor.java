package com.fabhotel.skillEndorsment.processor;
/**
 * @author: Sarthak Gupta
 * @description: ScoreEvaluatorProcessor interface
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;

import java.math.BigDecimal;

public interface ScoreEvaluatorProcessor {

    ScoreValuatorCondition getCondition();

    String[] evaluateScore(EvaluateScoreDto evaluateScoreDto);

    static BigDecimal findWeighedScoreAfterDeduction(EvaluateScoreDto evaluateScoreDto) {
        BigDecimal score = evaluateScoreDto.getScore();
        BigDecimal deductionPercentage = evaluateScoreDto.getEndorsedSkillCondition().getDeductionInPercentage();
        BigDecimal deductionAmount = score.multiply(deductionPercentage).divide(new BigDecimal(100));
        return deductionAmount;
    }
}
