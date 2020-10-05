package com.example.sprint2be.controller;

import com.example.sprint2be.model.UserPrincipal;
import com.example.sprint2be.model.login_msg.request.Login;
import com.example.sprint2be.model.login_msg.response.JwtResponse;
import com.example.sprint2be.model.user.RecoverPassword;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.repository.RecoverPasswordRepository;
import com.example.sprint2be.service.email.EmailService;
import com.example.sprint2be.service.recoverPassword.RecoverPasswordService;
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
import java.util.Optional;
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
    @Autowired
    EmailService emailService;
    @Autowired
    RecoverPasswordService recoverPasswordService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) throws AuthenticationException {

        Authentication authentication = authManager.authenticate(
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
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getListUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add-user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto, UriComponentsBuilder builder) {
        userService.create(userDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(userDto.getUserId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/lock-user")
    public ResponseEntity<Void> lockUser(@RequestBody List<UserDto> userDtoList) {
        userService.lockUser(userDtoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/recover-password")
    public ResponseEntity<?> recoverPassword(@RequestBody RecoverPassword recoverPassword) {
        User user = userService.findByUsername(recoverPassword.getUsername());
        if ((user != null) && (user.getEmail().equals(recoverPassword.getEmail()))) {
                String confirmCode = emailService.genConfirmCode();
                Optional<RecoverPassword> checkExist = recoverPasswordService.loadByUsername(recoverPassword.getUsername());
                if (checkExist.isPresent()){
                    recoverPassword = checkExist.get();
                }
                recoverPassword.setConfirmCode(confirmCode);
                recoverPasswordService.save(recoverPassword);
//Send Email
                return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/check-code/{confirmCode}")
    public ResponseEntity<?> checkConfirmCode(@PathVariable String confirmCode){
        Optional<RecoverPassword> checkExist = recoverPasswordService.loadByConfirmCode(confirmCode);
        if (checkExist.isPresent()){
            User user = userService.findByUsername(checkExist.get().getUsername());
            UserDto userDto = userService.convertToUserDto(user);
            recoverPasswordService.delete(checkExist.get());
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Integer id, @RequestParam String password){
        if (Boolean.TRUE.equals(userService.changePassword(id,password))){
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
