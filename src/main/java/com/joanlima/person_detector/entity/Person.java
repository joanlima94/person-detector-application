package com.joanlima.person_detector.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private Long countPerson;

    @Column(nullable = false)
    private LocalDateTime countAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getCountPerson() {
        return countPerson;
    }

    public void setCountPerson(Long countPerson) {
        this.countPerson = countPerson;
    }

    public LocalDateTime getCountAt() {
        return countAt;
    }

    public void setCountAt(LocalDateTime countAt) {
        this.countAt = countAt;
    }
}
