package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;

public interface UserEndorsementService {

    UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) throws RuntimeException;

    UserEndorsementResponseDto getUserEndorsedSkills(UserEndorsementRequestDto request);
}
