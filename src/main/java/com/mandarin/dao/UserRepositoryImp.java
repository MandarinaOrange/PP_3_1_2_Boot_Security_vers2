package com.mandarin.dao;

import com.mandarin.entity.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select distinct a from User a left join fetch a.roles", User.class).getResultList();
    }

    //Добавление user
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    //перезаписать user
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    //Удаление user
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
        return entityManager.createQuery("select distinct a from User a left join fetch a.roles where a.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    /*public int addInitAdmin() throws URISyntaxException, IOException {
        String result = "";
        try {
            result = new String(
                    Files.readAllBytes(Paths.get(getClass().getClassLoader()
                            .getResource("addInitAdmin.sql").toURI())), UTF_8);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("EX");
            return 1;
        }
        return 0;


    }*/
}
