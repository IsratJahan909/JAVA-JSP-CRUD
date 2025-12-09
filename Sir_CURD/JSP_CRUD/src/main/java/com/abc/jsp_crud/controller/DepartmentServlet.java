package com.abc.jsp_crud.controller;

import com.abc.jsp_crud.entity.Department;
import com.abc.jsp_crud.entity.Employee;
import com.abc.jsp_crud.service.DepartmentService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {

    private DepartmentService depService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        depService = new DepartmentService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//           req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//        if ("create".equals(action)) {
//            String name = req.getParameter("name");
//            String email = req.getParameter("email");
//            String dept = req.getParameter("department");
//            String salaryStr = req.getParameter("salary");
//            Double salary = (salaryStr != null && !salaryStr.isBlank()) ? Double.valueOf(salaryStr) : null;
//
//            Employee emp = new Employee(name, email, dept, salary);
//            dao.save(emp);
//            resp.sendRedirect(req.getContextPath() + "/employees");
//            return;
//        } else if ("update".equals(action)) {
//            Long id = Long.valueOf(req.getParameter("id"));
//            String name = req.getParameter("name");
//            String email = req.getParameter("email");
//            String dept = req.getParameter("department");
//            String salaryStr = req.getParameter("salary");
//            Double salary = (salaryStr != null && !salaryStr.isBlank()) ? Double.valueOf(salaryStr) : null;
//
//            Employee emp = new Employee(id, name, email, dept, salary);
//            dao.update(emp);
//            resp.sendRedirect(req.getContextPath() + "/employees");
//            return;
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/employees");
//   
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String val = req.getParameter("action");
        if (val == null) {val = "list";}
        switch (val) {
            case "add":
                req.getRequestDispatcher("/views/depForm.jsp").forward(req, resp);
                break;
            default:
                List<Department> depList = new ArrayList<>();
                depList = depService.getAll();
                req.setAttribute("departments", depList);
                req.getRequestDispatcher("/views/depList.jsp").forward(req, resp);
        }
        
        
//        switch (val) {
//            case "add":
//                req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
//                break;
//            case "edit":
//                String idStr = req.getParameter("id");
//                Long id = idStr != null ? Long.valueOf(idStr) : null;
//                Employee emp = dao.getById(id);
//                req.setAttribute("employee", emp);
//                req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
//                break;
//            case "delete":
//                String delId = req.getParameter("id");
//                if (delId != null) {
//                    dao.delete(Long.valueOf(delId));
//                }
//                resp.sendRedirect(req.getContextPath() + "/employees");
//                break;
//            default:
//                List<Employee> list = dao.getAll();
//                req.setAttribute("employees", list);
//                req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
//                break;
//        }
    }
}
