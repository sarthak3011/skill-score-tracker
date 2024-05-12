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
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    public UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) throws BadRequestException {
        log.info("[endorseUser] method invoked for UserEndorsementServiceImpl: {}", request);

        // Check if the user has already endorsed this skill to this user
        if (userEndorsementRepo.findByRevieweeAndReviewerAndSkillId(
                request.getRevieweeUserId(), request.getReviewerUserId(), request.getSkillId()).isPresent()) {
            throw new BadRequestException("User has already endorsed this skill to this user");
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
                .build();

        BigDecimal weighedScore = request.getScore();
        String reason = "";
        List<EndorsementScoreConfig.EndorsedSkillCondition> conditions = endorsementScoreConfig.getConditions();
        for (EndorsementScoreConfig.EndorsedSkillCondition scoreEvaluation : conditions) {
            ScoreEvaluatorProcessor scoreEvaluatorProcessor = scoreEvaluatorFactory.get(scoreEvaluation.getCondition());
            evaluateScoreDto.setEndorsedSkillCondition(scoreEvaluation);
            String[] weighedScoreReason = scoreEvaluatorProcessor.evaluateScore(evaluateScoreDto);
            weighedScore = new BigDecimal(weighedScoreReason[0]);
            reason = weighedScoreReason[1];
        }

        // Save the endorsement
        UserEndorsement userEndorsement = UserConverter.convertEndorsementDtoToEntity(request);
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
    public UserEndorsementResponseDto getUserEndorsedSkills(UserEndorsementRequestDto request) {
        return null;
    }

    private UserProfile getUserDetails(String userId) throws BadRequestException {
        return userService.getUserDetails(userId);
    }

}
