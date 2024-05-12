package com.fabhotel.skillEndorsment.processor;
/**
 * @author: Sarthak Gupta
 * @description: ScoreEvaluator factory class to find the processor
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreEvaluatorFactory {

    private final Map<ScoreValuatorCondition, ScoreEvaluatorProcessor> processorMap = new EnumMap<>(ScoreValuatorCondition.class);

    @Autowired
    public ScoreEvaluatorFactory(List<ScoreEvaluatorProcessor> processors) {
        for (ScoreEvaluatorProcessor processor : processors) {
            processorMap.put(processor.getCondition(), processor);
        }
    }

    public ScoreEvaluatorProcessor get(ScoreValuatorCondition contactType) {
        return processorMap.get(contactType);
    }
}
