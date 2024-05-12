package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import org.apache.coyote.BadRequestException;

public interface UserEndorsementService {

    UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) throws BadRequestException;

    UserEndorsementResponseDto getUserEndorsedSkills(UserEndorsementRequestDto request);
}
