package com.example.sprint2be.service.user;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {

    UserDto convertToUserDto(User user);
    User findByUsername(String username);
    Optional<User> findUserById(Integer id);
    UserDto findByEmail(String email);
    List<UserDto> findAll();
    UserDto findById(Integer id);
    User findByIdUser(Integer id);
    void create(UserDto userDto);
    void delete(Integer id);
    void lockUser(List<UserDto> userDtoList);
    Boolean checkUsernameExist(String username);
    UserDto getUserByUserName(String userName);
    void editUser(UserDto user, String userName);
    Boolean changePassword(Integer id, String password);
    boolean isCorrectConfirmPassword(UserDto userDto);
    UserDto findTopById();
    List<UserDto> findAllUserActivated();
    void unlockUser(List<UserDto> userDtoList);
    void deleteUser(List<String> ids);
    void updateUser(User user);
    void increasePoint(User user, double point);
    double pointReductionNoLogin(User user);
}


