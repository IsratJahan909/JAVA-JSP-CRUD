package com.israt.employees_database.entity;

import java.time.LocalDate;

public class employees {

    private Long id;

    private String name;

    public employees() {
    }

    public employees(Long id, String name, LocalDate Dob, String department) {
        this.id = id;
        this.name = name;
        this.Dob = Dob;
        this.department = department;
    }

    public employees(String name, LocalDate Dob, String department) {
        this.name = name;
        this.Dob = Dob;
        this.department = department;
    }

    @Override
    public String toString() {
        return "employees{" + "id=" + id + ", name=" + name + ", Dob=" + Dob + ", department=" + department + '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    private LocalDate Dob;
    private String department;
}
