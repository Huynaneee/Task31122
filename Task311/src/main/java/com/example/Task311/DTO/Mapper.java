package com.example.Task311.DTO;

import com.example.Task311.model.Role;
import com.example.Task311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {

    public UserDTO toDto(User user) {
        String name = user.getName();
        String lastName = user.getLastName();
        Set<Role> roles = user.getRoles();

        int id = user.getId();
        String email = user.getEmail();
        return new UserDTO(name,lastName,email,roles);

    }
    public User toUser(UserCreatDTO userDto) {
        return new User(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword(), new HashSet<>());
    }
}
