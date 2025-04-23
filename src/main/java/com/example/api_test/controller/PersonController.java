package com.example.api_test.controller;

import com.example.api_test.model.Person;
import com.example.api_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person insertPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    //    @PostMapping
    //    public Person createPerson(@RequestParam String name, @RequestParam int age) {
    //        return personService.createPerson(new Person(null, name, age));
    //    }

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable Long id) {
        return personService.findPerson(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    @ResponseBody // return 값을 reponse body에 담아서 보냄
    public String deletePerson(@PathVariable Long id) {
        if (personService.findPerson(id).isPresent()) {
            personService.deletePerson(id);
            return "<h3>삭제됨</h3>";
        } else {
            return "<h3>삭제할 데이터 없음</h3>";
        }
    }

}
