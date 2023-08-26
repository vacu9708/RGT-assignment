package com.rgt.rgt.user;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @GetMapping("/hi")
    String hi() {
        System.out.println("hi from 8080");
        return "hi from 8080";
    }

    @GetMapping("/OAuth/google/callback")
    String OAuthGoogleCallback(@Param("code") String code) {
        return userService.OAuthGoogleCallback(code);
    }
}
