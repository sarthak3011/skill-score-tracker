package com.fabhotel.skillEndorsment.converter;

import com.fabhotel.skillEndorsment.constant.ApplicationConstant;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserProfileDto;
import com.fabhotel.skillEndorsment.util.CommonUtils;

public class UserConverter {

    public static UserProfile convertDtoToEntity(UserProfileDto userProfileDto) {
       return  UserProfile.builder().userId(CommonUtils.generateUUID(ApplicationConstant.USER))
                .email(userProfileDto.getEmail())
                .name(userProfileDto.getName())
                .yearsOfExperience(userProfileDto.getYearsOfExperience())
                .industryId(userProfileDto.getIndustryId())
                .skills(userProfileDto.getSkills())
                .build();
    }

}
