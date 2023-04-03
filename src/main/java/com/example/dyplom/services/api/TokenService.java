package com.example.dyplom.services.api;

import com.example.dyplom.dto.TokenDto;
import com.example.dyplom.model.Token;

import java.util.List;

public interface TokenService{
    TokenDto save(TokenDto dto);
    void deleteByToken(String token);
    TokenDto findByToken(String token);
    List<TokenDto> getAll();
}
