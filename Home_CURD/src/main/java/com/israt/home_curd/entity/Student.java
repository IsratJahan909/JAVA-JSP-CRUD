
package com.israt.home_curd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Student {
    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDate dateOfBirth;        

 

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Student(String name, String email, String description, LocalDate dateOfBirth, LocalDateTime updatedAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
    }

    public Student(Long id, String name, String email, String description, LocalDate dateOfBirth, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
    }

    public Student() {
    }
    private LocalDateTime updatedAt;     
}


