package com.abc.jsp_crud.controller;

import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.service.EmployeeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService dao;

    @Override
    public void init() throws ServletException {
        dao = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
                break;
            case "edit":
                Long id = Long.parseLong(req.getParameter("id"));
                Employee emp = dao.findById(id);
                req.setAttribute("employee", emp);
                req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
                break;
            case "delete":
                dao.delete(Long.parseLong(req.getParameter("id")));
                resp.sendRedirect("employees");
                break;
            default:
                List<Employee> list = dao.listAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long id = req.getParameter("id").isEmpty() ? null : Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String gender = req.getParameter("gender");

        String[] skillsArr = req.getParameterValues("skills");
        //["IT","HR","MANAGEMENT"]
        StringJoiner sj = new StringJoiner(",");
       // "IT,HR,MANAGEMENT"
        if (skillsArr != null) {
            for (String s : skillsArr) {
                sj.add(s);
            }
        }
        Boolean fullTime = req.getParameter("fullTime") != null;

        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setDepartment(department);
        e.setSalary(salary);
        e.setDob(dob);
        e.setGender(gender);
        e.setSkills(sj.toString());
        e.setFullTime(fullTime);

        if (id == null) {
            dao.insert(e);
        } else {
            dao.update(e);
        }

        resp.sendRedirect("employees");
    }
}
