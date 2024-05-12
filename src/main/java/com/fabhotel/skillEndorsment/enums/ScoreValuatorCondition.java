package com.fabhotel.skillEndorsment.enums;

import lombok.Getter;

@Getter
public enum ScoreValuatorCondition {
    YEARS_OF_EXPERIENCE("years-of-experience"), SKILL_CLOSENESS("skill-closeness"), COWORKER_STATUS("coworker-status");

    final String value;

    ScoreValuatorCondition(String value) {
        this.value = value;
    }
}
