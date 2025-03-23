package com.example.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoAppApplication.class, args);
		// manually not di not in ioc container in jvm
		//Dev dev = new Dev();
		//dev.build();
		// di injection using context
		ApplicationContext context = SpringApplication.run(DemoAppApplication.class, args);
		Dev obj=context.getBean(Dev.class);
		obj.build();
	}

}
