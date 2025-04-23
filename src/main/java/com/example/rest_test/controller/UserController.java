package com.example.rest_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/person-view")
    public String personView(Model model) {
        return "person-view";
    }

    @GetMapping("/insert-form")
    public String insertForm(Model model) {
        return "insert-form";
    }

    @GetMapping("/update-form")
    public String updateForm(Model model) {
        return "update-form";
    }


    @GetMapping("/delete-form")
    public String deleteForm(Model model) {
        return "delete-form";
    }
}
