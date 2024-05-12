package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.entity.UserProfile;
import com.fabhotel.skillEndorsment.model.UserProfileDto;

public interface UserService {

    void createUserProfile(UserProfileDto userProfileDto) throws RuntimeException;

    UserProfile getUserDetails(String userId) throws RuntimeException;
}
