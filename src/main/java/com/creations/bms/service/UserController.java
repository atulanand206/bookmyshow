package com.creations.bms.service;

import com.creations.bms.models.UpdateUserDto;
import com.creations.bms.models.User;
import com.creations.bms.models.UserDto;
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