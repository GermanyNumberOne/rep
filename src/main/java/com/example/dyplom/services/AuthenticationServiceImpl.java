package com.example.dyplom.services;

import com.example.dyplom.dto.AuthenticationDto;
import com.example.dyplom.dto.RoleDto;
import com.example.dyplom.dto.UserDto;
import com.example.dyplom.model.Role;
import com.example.dyplom.model.User;
import com.example.dyplom.services.api.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private UserService userService;
    private RoleService roleService;
    private CountryService countryService;
    private LanguageService languageService;
    private ModelMapper modelMapper;


    @Transactional
    public UserDto registerUser(UserDto dto){
        List<Role> roles = new ArrayList<>();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        roles.add(modelMapper.map(roleService.getRoleByName("User"), Role.class));

        dto.setRoles(roles);
        dto.setCountry(countryService.findByName("Russia"));
        dto.setLanguage(languageService.findByName("Russian"));
        return userService.save(dto);
    }
}
