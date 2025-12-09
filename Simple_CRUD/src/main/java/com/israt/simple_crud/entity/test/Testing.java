package com.israt.simple_crud.entity.test;

import com.israt.simple_crud.entity.Employee;
import com.israt.simple_crud.entity.Service.EmployeeService;

public class Testing {

    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        System.out.println("Employee Management System");

        //Add 
        Employee e1 = new Employee("Jaman", "Developer", 50000.00);
        Employee e2 = new Employee("Jahan", "Developer", 5000.00);
        Employee e3 = new Employee("Juman", "Developer", 500000.00);

        es.addEmployee(e1);
        es.addEmployee(e2);
        es.addEmployee(e3);

    }

}
