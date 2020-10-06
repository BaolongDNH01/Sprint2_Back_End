package com.example.sprint2be.service.token;

import com.example.sprint2be.model.token.TokenDto;

import java.util.List;

public interface TokenService {
    void save(TokenDto tokenDto);
    void delete(Integer id);
    List<TokenDto> findAll();
    TokenDto findByNameToken(String nameToken);
}
