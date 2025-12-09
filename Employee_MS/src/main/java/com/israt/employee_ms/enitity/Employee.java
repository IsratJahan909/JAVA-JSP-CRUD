
package com.israt.employee_ms.enitity;

import java.time.LocalDate;

public class Employee {
   private int id;
    private String name;
    private LocalDate dob;
    private String department;

    // Constructors
    public Employee() {
    }

    public Employee(int id, String name, LocalDate dob, String department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
    }

    public Employee(String name, LocalDate dob, String department) {
        this.name = name;
        this.dob = dob;
        this.department = department;
    }

    // Getters and Setters
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", department='" + department + '\'' +
                '}';
    }
}
