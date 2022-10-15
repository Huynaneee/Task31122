package com.example.Task311.model;

import com.example.Task311.DTO.Mapper;
import com.example.Task311.DTO.UserDTO;
import com.example.Task311.service.RoleService;
import com.example.Task311.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class UserInitTest {

    private final UserService userService;
    private final RoleService roleService;

    private Mapper mapper;
    @Autowired
    public UserInitTest(UserService userService, RoleService roleService, Mapper mapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.mapper = mapper;
    }



    @PostConstruct
    public void generateUsersTest() {

        Role role1 = new Role(1L,"ROLE_USER");
        Role role2 = new Role(2L, "ROLE_ADMIN");

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);

        User admin = new User("Andrey", "Chernysow", "sda@yandex.ri", "101", Collections.singleton(role1));
        User user = new User("Misha", "Galustyan", "p2p@gmail.ci", "102", Collections.singleton(role1));
        User testUser = new User("Luna","Moon","moon21@sda", "100",roles);

        UserDTO admin1 = mapper.toDto(admin);
        UserDTO user1 =  mapper.toDto(user);
        UserDTO test = mapper.toDto(testUser);

        roleService.addRole(role1);
        roleService.addRole(role2);

        userService.addUser(admin1);
        userService.addUser(user1);
        userService.addUser(test);




    }
}
