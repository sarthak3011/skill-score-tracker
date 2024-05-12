package com.fabhotel.skillEndorsment.repository;
/**
 @author: Sarthak Gupta
 @description: User Endorsement Repository Interface
 @Date: 12th May 2024
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEndorsementRepo extends JpaRepository<UserEndorsementRepo, Long> {
}
