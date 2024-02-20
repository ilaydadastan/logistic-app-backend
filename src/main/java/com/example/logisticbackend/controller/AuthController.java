package com.example.logisticbackend.controller;

import com.example.logisticbackend.dto.UserCreateRequestVM;
import com.example.logisticbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody UserCreateRequestVM userCreateRequestVM) {
        userService.createUser(userCreateRequestVM);
        return ResponseEntity.ok("User creation successful");
    }
}
