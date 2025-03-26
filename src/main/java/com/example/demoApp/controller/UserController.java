package com.example.demoApp.controller;

import com.example.demoApp.Model.Users;
import com.example.demoApp.Repo.UserRepo;
import com.example.demoApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
   @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
       return userService.register(user);
   }
}
