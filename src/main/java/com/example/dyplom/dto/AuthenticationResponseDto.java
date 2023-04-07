package com.example.dyplom.dto;

import com.example.dyplom.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthenticationResponseDto {
    private String token;
    /*private String nickname;
    private String firstname;
    private String surname;
    private String email;*/
    private UserDto user;
}
