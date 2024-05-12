package com.fabhotel.skillEndorsment.controller;
/**
 * @author: Sarthak Gupta
 * @description: User endorsement Controller class to give endorsement to user skill and check the score
 * @Date: 12th May 2024
 */


import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import com.fabhotel.skillEndorsment.service.UserEndorsementService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-endorsement")
@RequiredArgsConstructor
public class UserEndorsementController {

    private final UserEndorsementService userEndorsementService;

    @PostMapping
    public UserEndorsementResponseDto giveUserEndorsement(@RequestBody UserEndorsementRequestDto request) throws BadRequestException {
        return userEndorsementService.endorseUser(request);
    }

    @GetMapping
    public HashMap<String, List<UserEndorsementResponseDto>> getUserSkillsEndorsement(@RequestParam String userId) {
        return null;
    }
}
