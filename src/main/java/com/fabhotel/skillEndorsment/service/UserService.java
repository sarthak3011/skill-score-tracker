package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.model.UserProfileDto;
import org.apache.coyote.BadRequestException;

public interface UserService {

    void createUserProfile(UserProfileDto userProfileDto) throws BadRequestException;
}
