package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.UserDto;
import com.messiaen.dropshipping.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserControler {

    IUserService userService;

    @Autowired
    public UserControler(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    private ResponseEntity<UserDto> register(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
