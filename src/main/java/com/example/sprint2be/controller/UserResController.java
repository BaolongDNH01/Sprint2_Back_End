package com.example.sprint2be.controller;


import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserResController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getListUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/add-user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto, UriComponentsBuilder builder){
        userService.create(userDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(userDto.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/lock-user")
    public ResponseEntity<Void> lockUser(@RequestBody UserDto userDto){
        userService.lockUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
