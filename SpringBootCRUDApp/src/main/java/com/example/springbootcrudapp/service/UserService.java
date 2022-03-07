package com.example.springbootcrudapp.service;

import com.example.springbootcrudapp.model.User;
import com.example.springbootcrudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById (int id) {
        return userRepository.getById(id);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }
    public void addUser (User user) {
        userRepository.save(user);
    }
    public void deleteUser (int id) {
        userRepository.deleteById(id);
    }
}
