package com.example.rest_test.service;

import com.example.rest_test.model.Person;
import com.example.rest_test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> searchPerson(long id) {
        return personRepository.findById(id);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

}
