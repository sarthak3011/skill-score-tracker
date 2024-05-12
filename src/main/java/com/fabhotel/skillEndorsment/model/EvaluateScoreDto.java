package com.fabhotel.skillEndorsment.model;

import com.fabhotel.skillEndorsment.config.EndorsementScoreConfig;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluateScoreDto {

    private UserProfile revieweeUser;
    private UserProfile reviewerUser;
    private BigDecimal score;
    private Long skillId;
    private String skillName;
    private EndorsementScoreConfig.EndorsedSkillCondition endorsedSkillCondition;
}
