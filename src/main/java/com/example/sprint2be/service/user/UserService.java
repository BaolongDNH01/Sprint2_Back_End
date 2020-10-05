package com.example.sprint2be.service.user;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;

import java.util.List;


public interface UserService {

    User findByUsername(String username);
    User findByEmail(String email);
    List<UserDto> findAll();
    UserDto findById(Integer id);
    void create(UserDto userDto);
    void delete(Integer id);
    void lockUser(List<UserDto> userDtoList);
    Boolean checkUsernameExist(String username);

    //    khanh
    UserDto getUserByUserName(String userName);
    void editUser(UserDto user, String userName);

}


