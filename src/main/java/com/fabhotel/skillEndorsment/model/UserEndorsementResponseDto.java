package com.fabhotel.skillEndorsment.model;
/**
 * @author: Sarthak Gupta
 * @description: User endorsement resposne DTO class to get score of endorsement
 * @Date: 12th May 2024
 */

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
public class UserEndorsementResponseDto {

    private String reviewerUserId;
    private String reviewerUserName;
    private String skillName;
    private BigDecimal actualScore;
    private BigDecimal weighedScore;
    private String scoreAdjustmentReason;
}
