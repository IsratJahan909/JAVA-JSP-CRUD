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
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

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
        // handle POST requests later
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String val = req.getParameter("action");
        if (val == null) {val = "list";}
        
        
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
