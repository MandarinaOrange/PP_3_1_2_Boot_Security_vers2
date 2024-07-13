package com.mandarin.dao;

import com.mandarin.model.User;

import java.util.List;

public interface UserRepository {

    public void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    public User getUser(long id);
    public User findByUsername(String username);
    public List<User> getAll();
}
