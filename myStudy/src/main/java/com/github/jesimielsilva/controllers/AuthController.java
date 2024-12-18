package com.github.jesimielsilva.controllers;

import com.github.jesimielsilva.dtos.AuthDto;
import com.github.jesimielsilva.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String auth(@RequestBody AuthDto authDto) {

        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());

        authenticationManager.authenticate(userAuthenticationToken);

        return authService.token(authDto);
    }
}
