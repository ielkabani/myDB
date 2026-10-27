package com.elkabani.mydb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index()
    {
    //    model.addAttribute("name", "Elkabani");
    //    return "index";
        return "redirect:/ui/users";
    }
}
