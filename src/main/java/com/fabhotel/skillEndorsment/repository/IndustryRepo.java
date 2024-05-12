package com.fabhotel.skillEndorsment.repository;

/**
 @author: Sarthak Gupta
 @description: Industry Repository Interface
 @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepo extends JpaRepository<Industry, Long> {
}
