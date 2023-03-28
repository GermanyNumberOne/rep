package com.example.dyplom.services.api;

import com.example.dyplom.dto.AuthenticationDto;
import com.example.dyplom.dto.UserDto;

public interface AuthenticationService {
    UserDto registerUser(UserDto dto);
}
