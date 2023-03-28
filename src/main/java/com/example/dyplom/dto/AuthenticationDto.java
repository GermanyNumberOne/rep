package com.example.dyplom.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthenticationDto {
    private String email;
    private String password;
}
