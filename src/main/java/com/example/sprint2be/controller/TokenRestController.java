package com.example.sprint2be.controller;

import com.example.sprint2be.model.token.TokenDto;
import com.example.sprint2be.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenRestController {
    @Autowired
    TokenService tokenService;

    @GetMapping("/all-token")
    public ResponseEntity<List<TokenDto>> getListToken(){
        return new ResponseEntity<>(tokenService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete-token/{id}")
    public ResponseEntity<Void> deleteToken(@PathVariable Integer id) {
        tokenService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
