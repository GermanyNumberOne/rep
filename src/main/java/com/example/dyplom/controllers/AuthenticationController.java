package com.example.dyplom.controllers;

import com.example.dyplom.dto.AuthenticationDto;
import com.example.dyplom.dto.AuthenticationResponseDto;
import com.example.dyplom.dto.UserDto;
import com.example.dyplom.security.JwtTokenProvider;
import com.example.dyplom.services.api.AuthenticationService;
import com.example.dyplom.services.api.TokenService;
import com.example.dyplom.services.api.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private TokenService tokenService;
    private UserService userService;

    @PostMapping(value = "/reg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto register(@RequestBody UserDto dto){
        return authenticationService.registerUser(dto);
    }


    @PostMapping(value = "/log-in", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody AuthenticationDto dto){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            User user = (User)authentication.getPrincipal();
            UserDto userDto = userService.findByEmail(authentication.getName());
            AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();
            authenticationResponseDto.setEmail(userDto.getEmail());
            authenticationResponseDto.setToken(jwtTokenProvider.generateToken(user));
            authenticationResponseDto.setFirstname(userDto.getFirstname());
            authenticationResponseDto.setNickname(userDto.getNickname());
            authenticationResponseDto.setSurname(userDto.getSurname());


            return ResponseEntity.ok().body(authenticationResponseDto);
            //return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtTokenProvider.generateToken(user)).body(userDto);
        }
        catch (AuthenticationException e){
            throw new BadCredentialsException("invalid login or password");
        }
    }

    @PostMapping(value = "/log-out")
    public ResponseEntity logout(){

        return ResponseEntity.ok(null);
    }
}
