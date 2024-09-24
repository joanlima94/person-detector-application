package com.joanlima.person_detector.repository;

import com.joanlima.person_detector.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
