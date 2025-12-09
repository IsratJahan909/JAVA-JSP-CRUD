package com.israt.jsp_maven.controller;

import com.israt.jsp_maven.entity.Student;
import com.israt.jsp_maven.service.StuService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/student")
public class StuServlet extends HttpServlet {

    private StuService stuService;

    @Override
    public void init() {
        stuService = new StuService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = stuService.readById(id);
                request.setAttribute("student", student);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                stuService.delete(id);
                response.sendRedirect("student?action=list");
            } else {
                List<Student> students = stuService.readAll();
                request.setAttribute("students", students);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equals(action)) {
                Student student = buildStudentFromRequest(request);
                stuService.create(student);
            } else if ("update".equals(action)) {
                Student student = buildStudentFromRequest(request);
                student.setId(Integer.parseInt(request.getParameter("id")));
                stuService.update(student);
            }
            response.sendRedirect("student?action=list");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    private Student buildStudentFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        LocalDate dob = LocalDate.parse(request.getParameter("dateOfBirth"));
        return new Student(0, name, email, description, dob, LocalDateTime.now());
    }
}
