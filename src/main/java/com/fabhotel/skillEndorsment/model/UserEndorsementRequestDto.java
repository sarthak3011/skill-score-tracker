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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEndorsementRequestDto {
    private String revieweeUserId;     // who is receiving the endorsement
    private String reviewerUserId;     // who is endorsing the skill
    private Integer skillId;
    private String skill;
    private int score;
}
