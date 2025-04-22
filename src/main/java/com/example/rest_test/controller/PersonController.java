package com.example.rest_test.controller;

import com.example.rest_test.model.Person;
import com.example.rest_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

//    @PostMapping
//    public Person createPerson(@RequestBody Person person) {}
    @PostMapping
    public Person createPerson(@RequestParam String name, @RequestParam int age) {
        return personService.createPerson(new Person(null, name, age));
    }


}
