package com.fabhotel.skillEndorsment.repository;
/**
 @author: Sarthak Gupta
 @description: User Endorsement Repository Interface
 @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.UserEndorsement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEndorsementRepo extends JpaRepository<UserEndorsement, Long> {

    Optional<UserEndorsement> findByRevieweeAndReviewerAndSkillId(String reviewee, String reviewer, Long skillId);

    List<UserEndorsement> findByRevieweeAndSkillNameIn(String revieweeUserId, List<String> skillNames);
}
