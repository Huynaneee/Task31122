package com.example.Task311.service;

import com.example.Task311.model.User;


import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> getListUsers();


}
