package com.fabhotel.skillEndorsment.repository;

/**
 @author: Sarthak Gupta
 @description: User Profile Repository Interface
 @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByEmail(String email);
}
