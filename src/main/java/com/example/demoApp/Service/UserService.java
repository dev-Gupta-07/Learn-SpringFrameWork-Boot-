package com.example.demoApp.Service;

import com.example.demoApp.Model.Users;
import com.example.demoApp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    private UserRepo userRepo;
   private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user) {
       user.setPassword(encoder.encode(user.getPassword()));

       userRepo.save(user);
       return user;

    }
}
