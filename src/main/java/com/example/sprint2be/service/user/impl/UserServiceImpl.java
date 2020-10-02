package com.example.sprint2be.service.user.impl;

import com.example.sprint2be.model.Rank;
import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.repository.RoleRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.rank.RankService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RankService rankService;
    private User convertToUser(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthday(userDto.getBirthday());
        user.setAddress(userDto.getAddress());
        user.setIdCard(userDto.getIdCard());
        user.setPoint(userDto.getPoint());
        user.setSignInRecent(userDto.getSignInRecent());
        user.setFlag(userDto.getFlag());
        user.setAvatar("https://firebasestorage.googleapis.com/v0/b/real-estate-d8b23.appspot.com/o/mWBlKu8IIggRNhyUutW8?alt=media&token=7f0c3569-e638-4160-bdb5-28cf4dfe22eb");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2).orElse(null));
        user.setRoles(roles);
        List<Rank> ranks = rankService.findAll();
        for (Rank rank: ranks){
            if (rank.getName().equals(userDto.getRank())) {
                user.setRank(rankService.findById(rank.getRankId()));
            }
        }
        return user;
    }
    private UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFullName(user.getFullName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setBirthday(user.getBirthday());
        userDto.setAddress(user.getAddress());
        userDto.setIdCard(user.getIdCard());
        userDto.setPoint(user.getPoint());
        userDto.setSignInRecent(user.getSignInRecent());
        userDto.setFlag(user.getFlag());
        userDto.setAvatar(user.getAvatar());
        List<Rank> ranks = rankService.findAll();
        userDto.setRank(user.getRank().getName());
        return userDto;
    }

//    @Override
//    public Boolean findByUsername(String username) {
//        return (userRepository.findByUsername(username).orElse(null) != null);
//    }
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
        userDto.setFlag("false");
        userRepository.save(convertToUser(userDto));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                userDto.setFlag("true");
                userRepository.save(convertToUser(userDto));
            }
        };
//        1000 time = 1s
        Timer timer = new Timer();
        timer.schedule(timerTask, userDto.getTimeLock());
    }

}

