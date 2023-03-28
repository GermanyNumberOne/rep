package com.example.dyplom.services;

import com.example.dyplom.dao.UserDao;
import com.example.dyplom.model.Role;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.example.dyplom.model.User user = userDao.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User \"" + email + "\" not found");
        }

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthorities(user.getRoles()))
                .build();
    }

    public List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }
}
