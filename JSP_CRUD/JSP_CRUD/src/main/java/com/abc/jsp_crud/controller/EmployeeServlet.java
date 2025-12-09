/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.abc.jsp_crud.controller;

import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.service.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
                break;
            case "edit":
                String idStr = req.getParameter("id");
                Long id = idStr != null ? Long.valueOf(idStr) : null;
                Employee emp = dao.getById(id);
                req.setAttribute("employee", emp);
                req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
                break;
            case "delete":
                String delId = req.getParameter("id");
                if (delId != null) {
                    dao.delete(Long.valueOf(delId));
                }
                resp.sendRedirect(req.getContextPath() + "/employees");
                break;
            default:
                List<Employee> list = dao.getAll();
                req.setAttribute("employees", list);
                req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // handle form submissions for create/update
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String dept = req.getParameter("department");
            String salaryStr = req.getParameter("salary");
            Double salary = (salaryStr != null && !salaryStr.isBlank()) ? Double.valueOf(salaryStr) : null;

            Employee emp = new Employee(name, email, dept, salary);
            dao.save(emp);
            resp.sendRedirect(req.getContextPath() + "/employees");
            return;
        } else if ("update".equals(action)) {
            Long id = Long.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String dept = req.getParameter("department");
            String salaryStr = req.getParameter("salary");
            Double salary = (salaryStr != null && !salaryStr.isBlank()) ? Double.valueOf(salaryStr) : null;

            Employee emp = new Employee(id, name, email, dept, salary);
            dao.update(emp);
            resp.sendRedirect(req.getContextPath() + "/employees");
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
