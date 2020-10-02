package com.example.sprint2be.service.user;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;

import java.util.List;


public interface UserService {

//    Boolean findByUsername(String username);

    List<UserDto> findAll();
    UserDto findById(Integer id);
    void create(UserDto userDto);
    void delete(Integer id);
    void lockUser(UserDto userDto);
}


