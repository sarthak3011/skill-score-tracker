package com.fabhotel.skillEndorsment.service.impl;
/**
 * @author: Sarthak Gupta
 * @description: User service class for profile creation business logic
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.converter.UserConverter;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserProfileDto;
import com.fabhotel.skillEndorsment.repository.UserProfileRepo;
import com.fabhotel.skillEndorsment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserProfileRepo userProfileRepo;

    @Override
    public void createUserProfile(UserProfileDto userProfileDto) throws RuntimeException {
        log.info("[createUserProfile] method invoked of UserServiceImpl with request : {}", userProfileDto);
        if (userProfileRepo.findByEmail(userProfileDto.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        UserProfile userProfile = UserConverter.convertDtoToEntity(userProfileDto);
        userProfileRepo.save(userProfile);
    }

    @Override
    public UserProfile getUserDetails(String userId) throws RuntimeException {
        return userProfileRepo.findByUserId(userId).orElseThrow(() -> new RuntimeException("User does not exist"));
    }
}
