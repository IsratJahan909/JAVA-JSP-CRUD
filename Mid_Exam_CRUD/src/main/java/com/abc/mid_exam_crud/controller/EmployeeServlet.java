package com.abc.mid_exam_crud.controller;

import com.abc.mid_exam_crud.entity.Employee;
import com.abc.mid_exam_crud.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService service;

    @Override
    public void init() throws ServletException {
        service = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertEmployee(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    // List All Employees
    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> list = service.getAllEmployees();
        request.setAttribute("listEmployee", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
        dispatcher.forward(request, response);
    }

    // Show Add Form
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/add.jsp");
        dispatcher.forward(request, response);
    }

    //  Show Edit Form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Employee existingEmployee = service.getEmployeeById(id);
        request.setAttribute("employee", existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/edit.jsp");
        dispatcher.forward(request, response);
    }

    //  Insert New Employee
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        double salary = Double.parseDouble(request.getParameter("salary"));
        LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate"));

        Employee newEmployee = new Employee(name, designation, salary, joiningDate);
        service.insertEmployee(newEmployee);
        response.sendRedirect("employee");
    }

    //  Update Employee
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        double salary = Double.parseDouble(request.getParameter("salary"));
        LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate"));

        Employee updatedEmployee = new Employee(id, name, designation, salary, joiningDate);
        service.updateEmployee(updatedEmployee);
        response.sendRedirect("employee");
    }

    //  Delete Employee
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        service.deleteEmployee(id);
        response.sendRedirect("employee");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
