
package com.israt.jsp_maven.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Student {
    



    private int id;
    private String name;
    private String email;
    private String description;
    private LocalDate dateOfBirth;     
    private LocalDateTime updatedAt;    

  
    public Student() {
    }

  
    public Student(int id, String name, String email, String description, LocalDate dateOfBirth, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

  
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
