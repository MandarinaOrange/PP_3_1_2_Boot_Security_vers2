package com.mandarin.dao;

import com.mandarin.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select distinct user from User user left join fetch user.roles where user.username = :username",
                User.class).setParameter("username", username).getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select distinct user from User user left join fetch user.roles",
                User.class).getResultList();
    }
}
