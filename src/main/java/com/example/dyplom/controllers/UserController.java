package com.example.dyplom.controllers;

import com.example.dyplom.dto.UserDto;
import com.example.dyplom.services.api.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    ///{id}/photo/change

    @PostMapping(value = "/{id}/photo/change", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto changePhoto(@PathVariable Long id, @RequestParam(name = "image") MultipartFile file){
        return userService.changePhoto(id, file);
    }

    @GetMapping(name = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    /*
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
     */



}
