package com.fabhotel.skillEndorsment.entity;

/**
 @author: Sarthak Gupta
 @description: User Entity class
 @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.converter.StringToListConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true)  //uuid of user
    private String userId;

    @Column
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "years_of_experience", nullable = false)
    private int yearsOfExperience;

    @Column(name = "industry_id", nullable = false)
    private int industryId;

    @Column
    @Convert(converter = StringToListConverter.class)
    private List<String> companies;

    @Column
    @Convert(converter = StringToListConverter.class)
    private List<String> skills;

}
