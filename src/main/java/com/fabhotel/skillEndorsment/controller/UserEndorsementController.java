package com.fabhotel.skillEndorsment.controller;
/**
 * @author: Sarthak Gupta
 * @description: User endorsement Controller class to give endorsement to user skill and check the score
 * @Date: 12th May 2024
 */


import com.fabhotel.skillEndorsment.model.UserEndorsementRequestDto;
import com.fabhotel.skillEndorsment.model.UserEndorsementResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-endorsement")
@RequiredArgsConstructor
public class UserEndorsementController {

    public UserEndorsementResponseDto giveUserEndorsement(@RequestBody UserEndorsementRequestDto request) {

    }
}
