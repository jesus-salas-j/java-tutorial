package com.tutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TutorialJavaApplication implements CommandLineRunner {

    public static void main (String[] args) {

        SpringApplication.run(TutorialJavaApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Hello world from Command Line Runner");
    }
}


