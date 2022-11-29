package com.example;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/person")
public class ExampleResource {

    @GetMapping
    @Transactional
    public List<Person> getAllPerson() {
        return Person.listAll();
    }

    @GetMapping("/name/{firstName}")
    @Transactional
    public List<Person> getAllPersonByFirstName(@RequestParam("firstName") String firstName) {
        return Person.findAllByFirstName(firstName);
    }

    @GetMapping("/name/{firstName}/{lastName}")
    @Transactional
    public Person getPersonByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return Person.findByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public Person addPerson(Person person) {
        Person.persist(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@RequestParam("id") Long id) {
        return Person.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePerson(@RequestParam("id") Long id) {
        Person.delete("id", id);
    }
}
