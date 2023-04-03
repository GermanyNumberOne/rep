package com.example.dyplom.dao;

import com.example.dyplom.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Token, String> {
    void deleteByToken(String token);
    Token findTokenByToken(String token);
}
