package com.mandarin.service;


import com.mandarin.dao.UserRepository;
import com.mandarin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository =  userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Transactional
    public User getById(long id) {
        User user = userRepository.getUser(id);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setPassword("AAA");
        return user;
        //return userRepository.getUser(id);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {


        if (!user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(userRepository.getUser(user.getId()).getPassword());
        }
        userRepository.updateUser(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    /*public int addInitAdmin() throws URISyntaxException, IOException {
        return userRepository.addInitAdmin();
    }*/
}
