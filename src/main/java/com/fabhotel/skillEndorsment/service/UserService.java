package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserProfileDto;
import org.apache.coyote.BadRequestException;

public interface UserService {

    void createUserProfile(UserProfileDto userProfileDto) throws BadRequestException;

    UserProfile getUserDetails(String userId) throws BadRequestException;
}
