package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserRepository {

    public void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    public User getUser(long id);
    public User findByUsername(String username);
    public List<User> getAll();
}
