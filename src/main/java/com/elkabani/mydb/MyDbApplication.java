package com.elkabani.mydb;

import com.elkabani.mydb.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {

      //  SpringApplication.run(MyDbApplication.class, args);
        var user = User.builder()
                .id(1L)
                .name("John")
                .email("john@example.com")
                .password("Password")
                .build();
    }

}
