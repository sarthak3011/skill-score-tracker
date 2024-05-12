package com.fabhotel.skillEndorsment.controller;
/**
 @author: Sarthak Gupta
 @description: User Controller class to expose API's to create profile, endorse Skill, getEndorsment
 @Date: 12th May 2024
 */

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping
    public void createProfile() {

    }
}
