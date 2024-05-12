package com.fabhotel.skillEndorsment.processor.impl;
/**
 * @author: Sarthak Gupta
 * @description: CoworkerEvaluation class to check for deduction in points on the basis of coworker status
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorProcessor;
import org.springframework.stereotype.Service;

@Service
public class CoworkerEvaluation implements ScoreEvaluatorProcessor {

    @Override
    public ScoreValuatorCondition getCondition() {
        return ScoreValuatorCondition.COWORKER_STATUS;
    }

    @Override
    public String[] evaluateScore(EvaluateScoreDto evaluateScoreDto) {
        return new String[]{String.valueOf(evaluateScoreDto.getScore()), ""};
    }
}
