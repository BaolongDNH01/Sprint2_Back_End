package com.example.sprint2be.service.user.impl;

import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.RoleRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Boolean save(User user) {
        if (Boolean.TRUE.equals(findByUsername(user.getUsername()))) {
            return false;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2).orElse(null));
        user.setRoles(roles);
        user.setAvatar("https://firebasestorage.googleapis.com/v0/b/real-estate-d8b23.appspot.com/o/mWBlKu8IIggRNhyUutW8?alt=media&token=7f0c3569-e638-4160-bdb5-28cf4dfe22eb");
        userRepository.save(user);
        return true;
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean findByUsername(String username) {
        return (userRepository.findByUsername(username).orElse(null) != null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteUser(Integer id) {
        if (Boolean.FALSE.equals(userRepository.existsById(id))) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

//    @Override
//    public User parseDto(UserDto userDto) {
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setUsername(userDto.getUsername());
//        user.setUserPassword(userDto.getUserPassword());
//        user.setFullName(userDto.getFullName());
//        user.setAddress(userDto.getAddress());
//        user.setEmail(userDto.getEmail()); // THIEN FIXED
//        user.setPhoneNumber(userDto.getPhoneNumber());
//        user.setAvatar(userDto.getAvatar());
//        user.setExamList(new ArrayList<>());
//        return user ;
//    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserName(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}

