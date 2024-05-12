package com.fabhotel.skillEndorsment.model;
/**
 * @author: Sarthak Gupta
 * @description: User Profile DTO class to create profile
 * @Date: 12th May 2024
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {

    private String name;
    private String email;
    private int yearsOfExperience;
    private int industryId;
    private List<String> skills;

}
