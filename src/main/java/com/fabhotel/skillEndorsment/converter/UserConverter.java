package com.fabhotel.skillEndorsment.converter;

import com.fabhotel.skillEndorsment.constant.ApplicationConstant;
import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.entity.UserEndorsement;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import com.fabhotel.skillEndorsment.model.UserProfileDto;
import com.fabhotel.skillEndorsment.util.CommonUtils;

public class UserConverter {

    public static UserProfile convertDtoToEntity(UserProfileDto request) {
       return  UserProfile.builder().userId(CommonUtils.generateUUID(ApplicationConstant.USER))
                .email(request.getEmail())
                .name(request.getName())
                .yearsOfExperience(request.getYearsOfExperience())
                .industryId(request.getIndustryId())
                .skills(request.getSkills())
                .companies(request.getCompanies())
                .build();
    }

    public static UserEndorsement convertEndorsementDtoToEntity(UserEndorsementRequestDto request, Skills skill) {
        return  UserEndorsement.builder()
                .reviewee(request.getRevieweeUserId())
                .reviewer(request.getReviewerUserId())
                .skillId(request.getSkillId())
                .skillName(skill.getName())
                .score(request.getScore())
                .build();
    }

    public static UserEndorsementResponseDto convertEndorsementToResponseDto(UserEndorsement endorsement) {
        return UserEndorsementResponseDto.builder()
                .reviewerUserId(endorsement.getReviewer())
                .reviewerUserName(endorsement.getReviewer())
                .actualScore(endorsement.getScore())
                .weighedScore(endorsement.getActualWeighedScore())
                .scoreAdjustmentReason(endorsement.getScoreAdjustmentReason())
                .skillName(endorsement.getSkillName())
                .build();
    }
}
