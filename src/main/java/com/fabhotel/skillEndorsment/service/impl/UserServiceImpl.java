package com.fabhotel.skillEndorsment.service.impl;

import com.fabhotel.skillEndorsment.converter.UserConverter;
import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserProfileDto;
import com.fabhotel.skillEndorsment.repository.UserProfileRepo;
import com.fabhotel.skillEndorsment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserProfileRepo userProfileRepo;

    @Override
    public void createUserProfile(UserProfileDto userProfileDto) throws BadRequestException {
        log.info("[createUserProfile] method invoked of UserServiceImpl with request : {}", userProfileDto);
        if (userProfileRepo.findByEmail(userProfileDto.getEmail()).isPresent()) {
            throw new BadRequestException("User already exists");
        }
        UserProfile userProfile = UserConverter.convertDtoToEntity(userProfileDto);
        userProfileRepo.save(userProfile);
    }
}
