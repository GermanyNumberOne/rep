package com.example.dyplom.controllers;

import com.example.dyplom.dto.UserDto;
import com.example.dyplom.services.api.UserService;
import com.example.dyplom.utils.FileUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    ///{id}/photo/change

    @PostMapping(value = "/change-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto changePhoto(@RequestParam(name = "image") MultipartFile file){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.changePhoto(user.getUsername(), file);
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.warn(user.getUsername());
        UserDto userDto = userService.findByEmail(user.getUsername());
        log.warn(userDto.toString());
        try {
            final ByteArrayResource byteArrayResource = new ByteArrayResource(Files.readAllBytes(Paths.get(
                        userDto.getImagePath()
                    )
            ));
            return ResponseEntity.status(HttpStatus.OK)
                    .body(byteArrayResource);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
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
