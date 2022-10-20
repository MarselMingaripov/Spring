package com.example.demojr;

import com.example.demojr.models.Client;
import com.example.demojr.service.ClientServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJrApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJrApplication.class, args);
        //Client client = new Client("Mars", "sdjk@mail.ru", "98988");
    }

}
