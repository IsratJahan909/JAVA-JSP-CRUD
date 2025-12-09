package com.abc.employee_system.controller;



import com.abc.employee_system.entity.Employees;
import com.abc.employee_system.service.EmployeeService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService empService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        empService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
                break;

            case "edit":
                Long id = Long.valueOf(req.getParameter("id"));
                Employees emp = empService.getById(id);
                req.setAttribute("employee", emp);
                req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
                break;

            case "delete":
                Long deleteId = Long.valueOf(req.getParameter("id"));
                empService.delete(deleteId);
                resp.sendRedirect(req.getContextPath() + "/employees");
                break;

            default:
                List<Employees> list = empService.getAll();
                req.setAttribute("employees", list);
                req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        double salary = Double.parseDouble(req.getParameter("salary"));
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String gender = req.getParameter("gender");

        String[] skillsArr = req.getParameterValues("skills");
        String skills = (skillsArr != null) ? String.join(",", skillsArr) : "";

        Boolean fullTime = req.getParameter("fullTime") != null;

        if (idStr == null || idStr.isEmpty()) {
            // Add new employee
            Employees emp = new Employees(name, department, salary, dob, gender, skills, fullTime);
            empService.add(emp);
        } else {
            // Update existing employee
            Long id = Long.valueOf(idStr);
            Employees emp = new Employees(id, name, department, salary, dob, gender, skills, fullTime);
            empService.update(emp);
        }

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}

