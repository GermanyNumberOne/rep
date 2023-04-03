package com.example.dyplom.controllers;

import com.example.dyplom.dto.UserDto;
import com.example.dyplom.services.api.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/get-all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping(value = "/{nickname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findByNickname(@PathVariable String nickname){
        return userService.findByNickname(nickname);
    }
}
