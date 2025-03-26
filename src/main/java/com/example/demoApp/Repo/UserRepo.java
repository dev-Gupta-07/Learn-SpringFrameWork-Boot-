package com.example.demoApp.Repo;

import com.example.demoApp.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUserName(String userName);

}
