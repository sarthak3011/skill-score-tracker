package com.fabhotel.skillEndorsment.repository;

/**
 @author: Sarthak Gupta
 @description: Skills Repository Interface
 @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {
}
