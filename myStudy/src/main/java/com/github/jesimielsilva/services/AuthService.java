package com.github.jesimielsilva.services;

import com.github.jesimielsilva.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    public String token(AuthDto authDto);
    public String ValidateToken(String token);
}
