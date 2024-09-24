package com.joanlima.person_detector.service;

import com.joanlima.person_detector.entity.Person;
import com.joanlima.person_detector.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        try {
            return personRepository.save(person);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save person: " + e.getMessage());
        }
    }

    public List<Person> findAllPerson() {
        try {
            return personRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all persons: " + e.getMessage());
        }
    }

    public Optional<Person> findPersonById(Long id) {
        try {
            return personRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find person with id: " + id);
        }
    }

}
