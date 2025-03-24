package com.example.demoApp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//controller for page for api restcontroller
public class HomeController {
    @RequestMapping("/")

    //or use controller above and @ResponseBody with request mapping
    public String greet(){
        System.out.println("in here..");
        return "Welcome  to Spring Boot Application";
    }
    // if more than one controller front controller by boot itself manages request mapping
}
