package com.example.demoApp;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    public void compile() {
        System.out.println("Hello from desktop");
    }
}
