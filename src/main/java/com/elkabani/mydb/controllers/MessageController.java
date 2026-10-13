package com.elkabani.mydb.controllers;

import com.elkabani.mydb.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/message")
    public Message  sayMessage()
    {
        return new Message("Hello From Spring Boot!");
    }
}
