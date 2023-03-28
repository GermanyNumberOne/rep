package com.example.dyplom.services;

import com.example.dyplom.dao.TokenDao;
import com.example.dyplom.dto.TokenDto;
import com.example.dyplom.model.Token;
import com.example.dyplom.services.api.TokenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenDao tokenDao;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public TokenDto save(TokenDto dto) {
        return modelMapper.map(tokenDao.save(modelMapper.map(dto, Token.class)), TokenDto.class);
    }

    @Transactional
    @Override
    public void deleteById(String token) {
        tokenDao.deleteByToken(token);
    }

    @Transactional
    @Override
    public TokenDto findById(String token) {
        return modelMapper.map(tokenDao.findById(token), TokenDto.class);
    }

    @Transactional
    @Override
    public List<TokenDto> getAll() {
        return tokenDao.findAll().stream().map(token -> modelMapper.map(token, TokenDto.class)).collect(Collectors.toList());
    }

}
