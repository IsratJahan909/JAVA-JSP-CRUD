
package com.israt.employee_ms.service;

import com.israt.employee_ms.enitity.Employee;
import com.israt.employees_ms.repository.DatabaseConnection;
import java.util.List;


public class EmployeeService {
        private final DatabaseConnection dao;

    public EmployeeService() {
        this.dao = new DatabaseConnection();
    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() == 0) {
            dao.insertEmployee(employee);
        } else {
            dao.updateEmployee(employee);
        }
    }

    public Employee getEmployee(int id) {
        return dao.selectEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return dao.selectAllEmployees();
    }

    public boolean deleteEmployee(int id) {
        return dao.deleteEmployee(id);
    }
}
