package com.itcat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addInitializers(new MyApplicationContextInitializer());
        ApplicationContext context = application.run(args);
        System.out.println("Application 运行成功!!!!!!!");

    }
}

