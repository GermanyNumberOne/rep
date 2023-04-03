package com.example.dyplom.services;

import com.example.dyplom.dao.UserDao;
import com.example.dyplom.dto.UserDto;
import com.example.dyplom.model.User;
import com.example.dyplom.services.api.RoleService;
import com.example.dyplom.services.api.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private RoleService roleService;

    private final ModelMapper modelMapper;

    @Override
    public UserDto findByEmail(String email) {
        return modelMapper.map(userDao.findByEmail(email), UserDto.class);
    }

    @Transactional
    @Override
    public List<UserDto> getAll(){
        return userDao.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserDto save(UserDto userDto){
        User user = userDao.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    @Transactional
    @Override
    public UserDto findById(Long id){
        return modelMapper.map(userDao.findById(id), UserDto.class);
    }

    @Transactional
    @Override
    public UserDto findByNickname(String nickname){
        return modelMapper.map(userDao.findByNickname(nickname), UserDto.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public void delete(UserDto userDto){
        userDao.delete(modelMapper.map(userDto, User.class));
    }

}
