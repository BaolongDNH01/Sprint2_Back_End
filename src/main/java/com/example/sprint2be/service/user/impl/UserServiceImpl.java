package com.example.sprint2be.service.user.impl;

import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.repository.RoleRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.rank.RankService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RankService rankService;
    @Autowired
    RoleRepository roleRepository;
    private User convertToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAccount(userDto.getAccount());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthday(userDto.getBirthday());
        user.setAddress(userDto.getAddress());
        user.setIdCard(userDto.getIdCard());
        user.setPoint(userDto.getPoint());
        user.setSignInRecent(userDto.getSignInRecent());
        user.setStatus_flag(userDto.getStatus_flag());
        user.setAvatar(userDto.getAvatar());
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2).orElse(null));
        user.setRoles(roles);
        user.setRank(rankService.findById(userDto.getRank()));
        return user;
    }
    private UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAccount(user.getAccount());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setBirthday(user.getBirthday());
        userDto.setAddress(user.getAddress());
        userDto.setIdCard(user.getIdCard());
        userDto.setPoint(user.getPoint());
        userDto.setSignInRecent(user.getSignInRecent());
        userDto.setStatus_flag(user.getStatus_flag());
        userDto.setAvatar(user.getAvatar());
        userDto.setRank(user.getRank().getRankId());
        return userDto;
    }
    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return (userRepository.findById(id)).map(this::convertToUserDto).orElse(null);
    }

    @Override
    public void create(UserDto userDto) {

        userRepository.save(convertToUser(userDto));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void lockUser(UserDto userDto) {
        userDto.setStatus_flag("false");
        userRepository.save(convertToUser(userDto));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                userDto.setStatus_flag("true");
                userRepository.save(convertToUser(userDto));
            }
        };
//        1000 time = 1s
        Timer timer = new Timer();
        timer.schedule(timerTask, userDto.getTime());
    }
}
