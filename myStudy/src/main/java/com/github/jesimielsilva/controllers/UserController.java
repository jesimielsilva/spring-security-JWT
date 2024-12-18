package com.github.jesimielsilva.controllers;

import com.github.jesimielsilva.dtos.UserDto;
import com.github.jesimielsilva.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/admin")
    private String getAdmin(){
        return "permissao de adm";
    }

    @GetMapping("/user")
    private String getUser(){
        return "permissao de user";
    }
}
