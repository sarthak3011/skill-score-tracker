package com.fabhotel.skillEndorsment.service.impl;
/**
 * @author: Sarthak Gupta
 * @description: User endorsement service class to give endorsement on user skill and get endorsment record
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.config.EndorsementScoreConfig;
import com.fabhotel.skillEndorsment.converter.UserConverter;
import com.fabhotel.skillEndorsment.entity.Skills;
import com.fabhotel.skillEndorsment.entity.UserEndorsement;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.EvaluateScoreDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorFactory;
import com.fabhotel.skillEndorsment.processor.ScoreEvaluatorProcessor;
import com.fabhotel.skillEndorsment.repository.UserEndorsementRepo;
import com.fabhotel.skillEndorsment.service.SkillService;
import com.fabhotel.skillEndorsment.service.UserEndorsementService;
import com.fabhotel.skillEndorsment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserEndorsementServiceImpl implements UserEndorsementService {

    private final UserEndorsementRepo userEndorsementRepo;

    private final SkillService skillService;

    private final UserService userService;

    private final EndorsementScoreConfig endorsementScoreConfig;

    private final ScoreEvaluatorFactory scoreEvaluatorFactory;

    @Override
    public UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) throws RuntimeException {
        log.info("[endorseUser] method invoked for UserEndorsementServiceImpl: {}", request);

        // Check if the user has already endorsed this skill to this user
        if (userEndorsementRepo.findByRevieweeAndReviewerAndSkillId(
                request.getRevieweeUserId(), request.getReviewerUserId(), request.getSkillId()).isPresent()) {
            throw new RuntimeException("User has already endorsed this skill to this user");
        }

        // Get user details and skill
        UserProfile revieweeUser = getUserDetails(request.getRevieweeUserId());
        UserProfile reviewerUser = getUserDetails(request.getReviewerUserId());
        Skills skill = skillService.getSkillById(request.getSkillId());

        // Evaluate the score
        EvaluateScoreDto evaluateScoreDto = EvaluateScoreDto.builder()
                .revieweeUser(revieweeUser)
                .reviewerUser(reviewerUser)
                .score(request.getScore())
                .skillId(request.getSkillId())
                .skillName(skill.getName())
                .build();

        BigDecimal weighedScore = request.getScore();
        String reason = "";
        List<EndorsementScoreConfig.EndorsedSkillCondition> conditions = endorsementScoreConfig.getConditions();
        for (EndorsementScoreConfig.EndorsedSkillCondition scoreEvaluation : conditions) {
            ScoreEvaluatorProcessor scoreEvaluatorProcessor = scoreEvaluatorFactory.get(scoreEvaluation.getCondition());
            evaluateScoreDto.setEndorsedSkillCondition(scoreEvaluation);
            String[] weighedScoreReason = scoreEvaluatorProcessor.evaluateScore(evaluateScoreDto);
            weighedScore = new BigDecimal(weighedScoreReason[0]);
            String adjustmentReason = weighedScoreReason[1];
            if (StringUtils.isNotEmpty(adjustmentReason)) {
                reason = StringUtils.isNotEmpty(adjustmentReason) ? reason.concat(",").concat(weighedScoreReason[1]) : reason.concat(weighedScoreReason[1]) ;
            }
        }

        // Save the endorsement
        UserEndorsement userEndorsement = UserConverter.convertEndorsementDtoToEntity(request, skill);
        userEndorsement.setActualWeighedScore(weighedScore);
        userEndorsement.setScoreAdjustmentReason(reason);
        userEndorsementRepo.save(userEndorsement);

        // Build and return the response
        return UserEndorsementResponseDto.builder()
                .reviewerUserId(reviewerUser.getUserId())
                .reviewerUserName(reviewerUser.getName())
                .actualScore(request.getScore())
                .weighedScore(weighedScore)
                .scoreAdjustmentReason(reason)
                .build();
    }

    @Override
    public Map<String, List<UserEndorsementResponseDto>> getUserEndorsedSkills(String userId) {
        UserProfile userProfile = getUserDetails(userId);
        List<String> skills = userProfile.getSkills();
        List<UserEndorsement> userEndorsements = userEndorsementRepo.findByRevieweeAndSkillNameIn(userId, skills);
        return convertToMap(userEndorsements);
    }

    public static Map<String, List<UserEndorsementResponseDto>> convertToMap(List<UserEndorsement> endorsements) {
        return endorsements.stream()
                .map(UserConverter::convertEndorsementToResponseDto)
                .collect(Collectors.groupingBy(UserEndorsementResponseDto::getSkillName));
    }


    private UserProfile getUserDetails(String userId) throws RuntimeException {
        return userService.getUserDetails(userId);
    }

}
