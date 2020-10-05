package com.example.sprint2be.service.token.impl;

import com.example.sprint2be.model.token.Token;
import com.example.sprint2be.model.token.TokenDto;
import com.example.sprint2be.repository.TokenRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserRepository userRepository;
    Token covertToToken(TokenDto tokenDto){
        Token token = new Token();
//        token.setId(tokenDto.getId());
        token.setUser(userRepository.findById(tokenDto.getIdUser()).orElse(null));
        token.setNameToken(tokenDto.getNameToken());
        return token;
    }
    TokenDto convertToTokenDto(Token token){
        TokenDto tokenDto = new TokenDto();
        tokenDto.setId(token.getId());
        tokenDto.setIdUser(token.getUser().getUserId());
        tokenDto.setNameToken(token.getNameToken());
        return tokenDto;
    }
    @Override
    public void save(TokenDto tokenDto) {
        tokenRepository.save(covertToToken(tokenDto));
    }

    @Override
    public void delete(Integer id) {
        tokenRepository.deleteById(id);
    }

    @Override
    public List<TokenDto> findAll() {
        return tokenRepository.findAll().stream().map(this::convertToTokenDto).collect(Collectors.toList());
    }
}
