package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.UserDto;
import com.messiaen.dropshipping.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {

    IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/restricted/user")
    @ResponseBody
    private ResponseEntity<UserDto> current(Principal principal) {
        return ResponseEntity.of(userService.findByUsername(principal.getName()));
    }

    @PostMapping("/user")
    private ResponseEntity<UserDto> register(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
