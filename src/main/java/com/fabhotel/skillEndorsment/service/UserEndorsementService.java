package com.fabhotel.skillEndorsment.service;

import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;

import java.util.List;
import java.util.Map;

public interface UserEndorsementService {

    UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) throws RuntimeException;

    Map<String, List<UserEndorsementResponseDto>> getUserEndorsedSkills(String userId);
}
