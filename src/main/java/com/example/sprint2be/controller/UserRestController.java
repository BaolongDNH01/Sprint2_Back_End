package com.example.sprint2be.controller;

import com.example.sprint2be.model.UserPrincipal;
import com.example.sprint2be.model.auction.dto.UserBidderDto;
import com.example.sprint2be.model.login_msg.request.Login;
import com.example.sprint2be.model.login_msg.response.JwtResponse;
import com.example.sprint2be.model.token.TokenDto;
import com.example.sprint2be.model.user.RecoverPassword;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.service.auction.BidderService;
import com.example.sprint2be.service.captcha.CaptchaService;
import com.example.sprint2be.service.captcha.ICaptchaService;
import com.example.sprint2be.service.email.EmailService;
import com.example.sprint2be.service.recoverPassword.RecoverPasswordService;
import com.example.sprint2be.service.security.JwtProvider;
import com.example.sprint2be.service.token.TokenService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    TokenService tokenService;
    @Autowired
    com.example.sprint2be.service.EmailService getEmailService;
    @Autowired
    BidderService bidderService;
    @Autowired
    private ICaptchaService captchaService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) throws AuthenticationException {
//        quan
        User user = userService.findByUsername(loginRequest.getUsername());
        if (user.getSignInRecent() != null && !user.getUsername().equals("admin")){
            userService.increasePoint(user, userService.pointReductionNoLogin(user) * (-50));
        }
//
        if (!user.getEnabled().equals("false")) {
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
            //        quan
            Date today = new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
            String s = timeFormat.format(today.getTime());
            user.setSignInRecent(s);
            userService.updateUser(user);
            return ResponseEntity.ok(response);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/lock-user")
    @PreAuthorize("hasRole('ADMIN')")
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
            if (checkExist.isPresent()) {
                recoverPassword = checkExist.get();
            }
            recoverPassword.setConfirmCode(confirmCode);
            recoverPasswordService.save(recoverPassword);
            getEmailService.sendEmail(recoverPassword.getEmail(), "Phục Hồi Mật Khẩu",
                    "Bạn vừa yêu cầu phục hồi lại mật khẩu đăng nhập của tài khoản: " + recoverPassword.getUsername() + "\n" +
                            "Mã Xác Nhận: " + confirmCode + "\n" +
                            "Xin sử dụng đường dẫn sau đây và nhập vào mã xác nhận trong email này để có thể thực hiệc việc đặt lại mật khẩu mới:" +
                            " http://localhost:4200/recover-password?confirmCode=" + confirmCode +"&username="+ recoverPassword.getUsername() +"\n"+
                            "Nếu đây không phải là bạn, xin hãy đăng nhập và thực hiện thay đổi mật khẩu hiện tại.");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/check-code/{confirmCode}")
    public ResponseEntity<?> checkConfirmCode(@PathVariable String confirmCode) {
        Optional<RecoverPassword> checkExist = recoverPasswordService.loadByConfirmCode(confirmCode);
        if (checkExist.isPresent()) {
            User user = userService.findByUsername(checkExist.get().getUsername());
            UserDto userDto = userService.convertToUserDto(user);
            recoverPasswordService.delete(checkExist.get());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Integer id, @RequestParam String password) {
        if (Boolean.TRUE.equals(userService.changePassword(id, password))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/getUserByUserName/{username}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByUserName(username), HttpStatus.OK);
    }

    @PostMapping("editUserInfo/{username}")
    public void editUserInfo(@PathVariable String username, @RequestBody UserDto userDto) {
        userService.editUser(userDto, username);
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult,
                                              HttpServletRequest request) {
//        String response = request.getParameter("g-recaptcha-response");
//        if (response.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        System.out.println(response);
//        captchaService.processResponse(response, CaptchaService.REGISTER_ACTION);
        User user = userService.findByUsername(userDto.getUsername());
        if (null != user) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        this.userService.create(userDto);
        TokenDto tokenDto = new TokenDto();
        userDto = userService.convertToUserDto(userService.findByUsername(userDto.getUsername()));
        tokenDto.setIdUser(userDto.getUserId());
        tokenDto.setNameToken(Integer.toString((new Random()).nextInt()));
        tokenService.save(tokenDto);
        tokenDto = tokenService.findByNameToken(tokenDto.getNameToken());
        TokenDto finalTokenDto = tokenDto;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                tokenService.delete(finalTokenDto.getId());
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 24 * 60 * 60 * 1000);

        getEmailService.sendEmail(userDto.getEmail(), "Hello bà con", "Chào mừng bạn đã đến trang đấu giá vủa chúng tôi, vui lòng click vào đường link kích hoạt tài khoản " + userDto.getUsername() + " :\n http://localhost:4200/activated-account/" + tokenDto.getNameToken() +
                '\n' + "đường dẫn có thời hạn 1 ngày");
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("getAllBidderByUserName/{username}")
    public ResponseEntity<List<UserBidderDto>> getAllBidderByUserName(@PathVariable String username) {
        return new ResponseEntity<>(bidderService.findAllBidderByU(username), HttpStatus.OK);
    }

    @GetMapping("/user-activated")
    public ResponseEntity<List<UserDto>> findAllUserActivated() {
        return new ResponseEntity<>(userService.findAllUserActivated(), HttpStatus.OK);
    }

    @PostMapping("/unlock-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> unlockUser(@RequestBody List<UserDto> userDtoList) {
        userService.unlockUser(userDtoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-users/{ids}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUsers(@PathVariable List<String> ids) {
        userService.deleteUser(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/dsa/{point}")
    public ResponseEntity<Void> increasePoint (@PathVariable double point, @RequestBody Integer id){
        userService.increasePoint(userService.findByIdUser(id), point);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
