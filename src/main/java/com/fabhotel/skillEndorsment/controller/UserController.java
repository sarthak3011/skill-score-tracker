package com.fabhotel.skillEndorsment.controller;
/**
 * @author: Sarthak Gupta
 * @description: User Controller class to expose API's to create profile
 * @Date: 12th May 2024
 */

import com.fabhotel.skillEndorsment.model.UserProfileDto;
import com.fabhotel.skillEndorsment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createProfile(@RequestBody UserProfileDto userProfileDto) throws RuntimeException {
        userService.createUserProfile(userProfileDto);
    }
}
