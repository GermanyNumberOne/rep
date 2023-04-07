package com.example.dyplom.services.api;

import com.example.dyplom.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService extends AbstractService<UserDto> {
    UserDto findById(Long id);
    UserDto findByNickname(String nickname);
    void delete(UserDto userDto);
    UserDto findByEmail(String email);
    UserDto changePhoto(Long id, MultipartFile file);
}
