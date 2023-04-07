package com.example.dyplom.dto;

import com.example.dyplom.model.Country;
import com.example.dyplom.model.Language;
import com.example.dyplom.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto extends BaseDto {
    private String nickname;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    private String imagePath;

    private Language language;
    private Country country;
    private List<Role> roles;
}
