package com.example.Task311.dao;


import com.example.Task311.DTO.RoleDTO;
import com.example.Task311.DTO.UserDTO;
import com.example.Task311.model.Role;
import com.example.Task311.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(UserDTO user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
       User user = getUserById(id);
       entityManager.remove(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("select u FROM User u where u.name = :name", User.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return entityManager.createQuery("select u FROM User u where u.name = :name", User.class)
                .setParameter("name", username).getSingleResult();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
