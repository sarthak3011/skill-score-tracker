package com.fabhotel.skillEndorsment.model;
/**
 * @author: Sarthak Gupta
 * @description: User endorsement DTO class to give endorsement on user skill
 * @Date: 12th May 2024
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEndorsementRequestDto {
    @NotEmpty(message = "revieweeUserId cannot be empty")
    private String revieweeUserId;     // who is receiving the endorsement
    @NotEmpty(message = "reviewerUserId cannot be empty")
    private String reviewerUserId;     // who is endorsing the skill
    @NotEmpty(message = "skillId cannot be empty")
    private Long skillId;
    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 10, message = "Score cannot be greater than 10")
    private BigDecimal score;
}
