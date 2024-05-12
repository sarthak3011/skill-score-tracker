package com.fabhotel.skillEndorsment.entity;

/**
 @author: Sarthak Gupta
 @description: User Endorsement Entity class; User will endorse skill and give them score will be stored here
 @Date: 12th May 2024
 */


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "user_endorsement")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEndorsement extends BaseEntity {

    @Column(nullable = false)
    private String reviewee;      // who is receiving the endorsment

    @Column(nullable = false)
    private String reviewer;      // who is endorsing the skill

    @Column(name = "fk_skill_id", nullable = false)
    private Long skillId;

    @Column(nullable = false)
    private BigDecimal score;

    @Column(name = "actual_weighed_score", nullable = false)
    private BigDecimal actualWeighedScore;
}
