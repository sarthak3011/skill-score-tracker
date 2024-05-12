package com.fabhotel.skillEndorsment.processor;
/**
 * @author: Sarthak Gupta
 * @description: ScoreEvaluatorProcessor interface
 * @Date: 12th May 2024
 */


import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;

public interface ScoreEvaluatorProcessor {

    ScoreValuatorCondition getCondition();

    String[] evaluateScore(EvaluateScoreDto evaluateScoreDto);
}
