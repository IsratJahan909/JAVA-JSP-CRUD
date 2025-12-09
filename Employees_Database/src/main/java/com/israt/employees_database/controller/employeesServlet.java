package com.israt.employees_database.controller;

import com.israt.employees_database.entity.employees;
import com.israt.employees_database.service.employeesService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/employees")
public class employeesServlet extends HttpServlet {

    private employeesService service;

    public void init() {
        service = new employeesService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action: " + action);
        
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createEmployee(request, response);
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
                listEmployee(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<employees> list = service.getAllEmployees();
        request.setAttribute("List", list);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dobStr = request.getParameter("dob");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dobStr, formatter);
        String department = request.getParameter("department");

        employees emp = new employees(null, name, dob, department);
        service.addEmployee(emp);
        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employees emp = service.getEmployeeById(id);
        request.setAttribute("employee", emp); // ✅ key corrected
        request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dobStr = request.getParameter("dob");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dobStr, formatter);
        String department = request.getParameter("department");

        employees emp = new employees((long) id, name, dob, department);
        service.updateEmployee(emp);
        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteEmployee(id);
        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
