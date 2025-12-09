//package com.abc.employee_crud.controller;
//
//import com.abc.employee_crud.entity.Employee;
//import com.abc.employee_crud.service.EmployeeService;
//import java.io.IOException;
//import java.sql.Date;
//import java.util.List;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.time.LocalDate;
//
//@WebServlet("/employees")
//
//public class EmployeeServlet extends HttpServlet {
//    private EmployeeService employeeService;
//
//    public void init() {
//        employeeService = new EmployeeService();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if (action == null) {
//            action = "list";
//        }
//
//        switch (action) {
//            case "new":
//                showNewForm(request, response);
//                break;
//            case "create":
//                createEmployee(request, response);
//                break;
//            case "delete":
//                deleteEmployee(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "update":
//                updateEmployee(request, response);
//                break;
//            default:
//                listEmployee(request, response);
//                break;
//        }
//    }
//
//    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Employee> employeeList = employeeService.getAllEmployees();
//        request.setAttribute("employeeList", employeeList);
//        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
//    }
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
//    }
//
//    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        String name = request.getParameter("name");
//        Date dob;
//        dob = Date.valueOf(request.getParameter("dob"));
//        String department = request.getParameter("department");
//
//        Employee employee = new Employee();
//        employee.setName(name);
//        employee.setDob(dob);
//        employee.setDepartment(department);
//
//        employeeService.addEmployee(employee);
//        response.sendRedirect("employees");
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = employeeService.getEmployeeById(id);
//        request.setAttribute("employee", employee);
//        request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
//    }
//
//    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        Date dob = Date.valueOf(request.getParameter("dob"));
//        String department = request.getParameter("department");
//
//        Employee employee = new Employee();
//        employee.setId(id);
//        employee.setName(name);
//        employee.setDob(dob);
//        employee.setDepartment(department);
//
//        employeeService.updateEmployee(employee);
//        response.sendRedirect("employees");
//    }
//
//    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        employeeService.deleteEmployee(id);
//        response.sendRedirect("employees");
//    }
//}
