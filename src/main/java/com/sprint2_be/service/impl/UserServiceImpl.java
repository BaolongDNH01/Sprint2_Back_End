package com.sprint2_be.service.impl;

import com.sprint2_be.model.entity.User;
import com.sprint2_be.model.repository.UserRepository;
import com.sprint2_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
