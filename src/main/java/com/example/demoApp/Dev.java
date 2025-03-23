package com.example.demoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    @Autowired //field injection
    //@Qualifier("laptop") first letter small
  // private Laptop laptop;
            // now when computer interface
    private Computer laptop;
    // now after creating desktop now which computer it should take
    // required single bean but 2 found
    // either remove component from any of them
    // or use qualifier annotation with required class name

   //constructor injection autowired not needed
//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//    }
//    @Autowired necessary in setter method
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
    public void build(){
        laptop.compile();
        System.out.println("Hello from dev");
    }
}
