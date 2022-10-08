package com.example.Task311.model;

import com.example.Task311.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserInitTest {

    private final UserService userService;

    @Autowired
    public UserInitTest(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    public void generateUsersTest() {

        userService.addUser(new User("testName1", "testLastName1", "testMail1"));
        userService.addUser(new User("Bot", "Semenov", "bS@mail.ru"));
        userService.addUser(new User("Arnold", "Schwarzenegger", "AS@yandex.ru"));


    }
}
