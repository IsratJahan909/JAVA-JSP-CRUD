
package com.abc.employee_system.entity;

import java.time.LocalDate;

public class Employees {
        private Long id;
    private String name; 
    private String department;
    private double salary;
    private LocalDate dob;
    private String gender;   //radio
    private String skills;   //comma-separated
    private Boolean fullTime;   //checkbox 

  

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getSkills() {
        return skills;
    }

    public Boolean getFullTime() {
        return fullTime;
    }

    public Employees() {
    }

    public Employees(String name, String department, double salary, LocalDate dob, String gender, String skills, Boolean fullTime) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.dob = dob;
        this.gender = gender;
        this.skills = skills;
        this.fullTime = fullTime;
    }

    public Employees(Long id, String name, String department, double salary, LocalDate dob, String gender, String skills, Boolean fullTime) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.dob = dob;
        this.gender = gender;
        this.skills = skills;
        this.fullTime = fullTime;
    }
    
      @Override
    public String toString() {
        return "employees{" + "id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + ", dob=" + dob + ", gender=" + gender + ", skills=" + skills + ", fullTime=" + fullTime + '}';
    }

}
