package com.mandarin.service;


import com.mandarin.entity.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(long id);
    public void deleteUser(long id);
    public void saveUser(User user);
    public void updateUser(User user);
    public User findByUsername(String username);
    //public int addInitAdmin() throws URISyntaxException, IOException;
}
