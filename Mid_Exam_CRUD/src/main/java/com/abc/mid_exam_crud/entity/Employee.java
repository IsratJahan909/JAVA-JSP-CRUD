
package com.abc.mid_exam_crud.entity;

import java.time.LocalDate;


public class Employee {
    private Long id;
    private String name;
    private String designation;
    private double salary;
    private LocalDate joiningDate;

    

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public Employee(String name, String designation, double salary, LocalDate joiningDate) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public Employee() {
    }

    public Employee(Long id, String name, String designation, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + ", joiningDate=" + joiningDate + '}';
    }
    
}
