package com.creations.bms.controllers;

import com.creations.bms.models.users.User;
import com.creations.bms.models.users.UserDto;
import com.creations.bms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService fUserService;

    public UserController(UserService userService) {
        this.fUserService = userService;
    }

    @PostMapping("/v1/user")
    public User createUser(@RequestBody UserDto userDto) {
        return fUserService.createUser(userDto);
    }

    @GetMapping("/v1/user/{userId}")
    public User getUser(@PathVariable("userId") UUID userId) {
        return fUserService.getUser(userId);
    }

    @DeleteMapping("/v1/user/{userId}")
    public void deleteUser(@PathVariable("userId") UUID userId) {
        fUserService.deleteUser(userId);
    }
}