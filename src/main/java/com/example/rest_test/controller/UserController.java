package com.example.rest_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        return "form";
    }
}
