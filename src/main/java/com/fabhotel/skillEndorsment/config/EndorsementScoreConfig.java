package com.fabhotel.skillEndorsment.config;

import com.fabhotel.skillEndorsment.enums.ScoreValuatorCondition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "endorsed-skill")
@PropertySource(value = "classpath:endorsed-skill.yml", factory = YamlPropertySourceFactory.class)
public class EndorsementScoreConfig {

    private List<EndorsedSkillCondition> conditions;

    @Getter
    @Setter
    public static class EndorsedSkillCondition {
        private ScoreValuatorCondition condition;
        private BigDecimal deductionInPercentage;
        private String scoreAdjustmentReason;
    }
}
