package com.p23studios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BasicSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringApiApplication.class, args);
    }

    @GetMapping()
    public String helloWorld(){
        return "Hello there, Spring API!";
    }

}
