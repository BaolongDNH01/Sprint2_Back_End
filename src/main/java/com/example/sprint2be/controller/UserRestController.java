package com.example.sprint2be.controller;

import com.example.sprint2be.model.UserPrincipal;
import com.example.sprint2be.model.login_msg.request.Login;
import com.example.sprint2be.model.login_msg.response.JwtResponse;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.service.security.JwtProvider;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRestController {
    @Autowired
    UserService userService;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authManager;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) throws AuthenticationException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generatingJwt(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        JwtResponse response = new JwtResponse(
                token,
                userPrincipal.getUsername(),
                userPrincipal.getEmail(),
                userPrincipal.getAvatar(),
                userPrincipal.getAuthorities()
        );
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
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
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(userDto.getUserId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-user/{id}")
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
