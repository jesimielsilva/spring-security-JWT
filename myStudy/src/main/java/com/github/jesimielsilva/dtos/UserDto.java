package com.github.jesimielsilva.dtos;

import com.github.jesimielsilva.enums.RoleEnum;

public record  UserDto(
        String name,
        String email,
        String login,
        String password,
        RoleEnum role
) {
}
