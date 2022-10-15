package com.example.Task311.dao;

import com.example.Task311.DTO.UserDTO;
import com.example.Task311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.List;

public interface UserDao {
    void addUser(UserDTO user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> getListUsers();
    User getUserByName (String name);
    UserDetails loadUserByUsername (String username);
}
