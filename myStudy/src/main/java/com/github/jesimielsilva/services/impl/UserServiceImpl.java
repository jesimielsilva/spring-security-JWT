package com.github.jesimielsilva.services.impl;

import com.github.jesimielsilva.dtos.UserDto;
import com.github.jesimielsilva.models.User;
import com.github.jesimielsilva.repositories.UserRepository;
import com.github.jesimielsilva.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(UserDto userDto) {

        User userExists     = userRepository.findByLogin(userDto.login());
        User emailExists    = userRepository.findByEmail(userDto.email());

        if (userExists != null) {
            throw new IllegalArgumentException("Login ja existe");
        }
        if (emailExists != null) {
            throw new IllegalArgumentException("Email já existe");
        }

        var passwordHash = passwordEncoder.encode(userDto.password());

        User userEntity = new User( userDto.name(),
                                    userDto.email(),
                                    userDto.login(),
                                    passwordHash,
                                    userDto.role());
        User newUser = userRepository.save(userEntity);
        return new UserDto( newUser.getName(),
                            newUser.getEmail(),
                            newUser.getLogin(),
                            newUser.getPassword(),
                            newUser.getRole());
    }
}
