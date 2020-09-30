package com.sprint2_be.service;

import com.sprint2_be.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void delete(Integer id);
}
