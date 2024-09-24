package com.joanlima.person_detector.controller;


import com.joanlima.person_detector.entity.Person;
import com.joanlima.person_detector.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/all-person")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = personService.findAllPerson();
        return ResponseEntity.ok(personList);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> personById = personService.findPersonById(id);
        return personById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
