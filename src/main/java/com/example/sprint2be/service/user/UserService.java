package com.example.sprint2be.service.user;
import com.example.sprint2be.model.user.User;

import java.util.List;


public interface UserService {
    Boolean save(User user);

    void edit(User user);

    Boolean findByUsername(String username);

    List<User> findAll();

    Boolean deleteUser(Integer id);


//    User parseDto(UserDto userDto);


    User findById(Integer id);

    User findUserName(String username);
}


