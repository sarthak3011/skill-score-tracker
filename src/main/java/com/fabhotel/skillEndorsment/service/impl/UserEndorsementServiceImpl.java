package com.fabhotel.skillEndorsment.service.impl;

import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import com.fabhotel.skillEndorsment.repository.UserEndorsementRepo;
import com.fabhotel.skillEndorsment.service.UserEndorsementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserEndorsementServiceImpl implements UserEndorsementService {

    private final UserEndorsementRepo userEndorsementRepo;

    @Override
    public UserEndorsementResponseDto endorseUser(UserEndorsementRequestDto request) {
        return null;
    }
}
