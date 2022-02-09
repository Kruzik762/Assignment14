package com.coderscamps.Assignment14.service;


import com.coderscamps.Assignment14.domain.User;
import com.coderscamps.Assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public String findNameById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user.getName();
    }

    public User createUser(String displayName) {
        User user = new User();
        user.setName(displayName);
        return userRepository.save(user);
    }
}
