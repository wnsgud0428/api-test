package com.example.api_test.service;

import com.example.api_test.model.Person;
import com.example.api_test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @CacheEvict(value = "persons", allEntries = true)
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findPerson(long id) {
        return personRepository.findById(id);
    }

    @Cacheable("persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // update는 savePerson 으로 대체

    @CacheEvict(value = "persons", allEntries = true)
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

}
