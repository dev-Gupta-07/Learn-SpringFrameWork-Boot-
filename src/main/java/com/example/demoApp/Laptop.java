package com.example.demoApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // in case of 2 primary means more priority
public class Laptop implements Computer {
    public void compile(){
        System.out.println("Compile with bugs");
    }
}
