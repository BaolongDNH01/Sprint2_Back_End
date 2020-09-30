package com.example.sprint2be.controller;

import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class UserController {
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
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        userService.create(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
