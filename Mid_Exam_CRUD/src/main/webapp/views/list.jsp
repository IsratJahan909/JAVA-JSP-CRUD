<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.abc.mid_exam_crud.entity.Employee" %>
<%
    List<Employee> list = (List<Employee>) request.getAttribute("listEmployee");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center text-primary mb-4">All Employees</h2>

    <div class="text-end mb-3">
        <a href="employee?action=new" class="btn btn-success"> Add Employee</a>
        <a href="index.jsp" class="btn btn-secondary"> Home</a>
    </div>

    <table class="table table-bordered table-striped shadow">
        <thead class="table-primary text-center">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Salary</th>
                <th>Joining Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (list != null && !list.isEmpty()) {
                for (Employee emp : list) {
        %>
            <tr class="text-center">
                <td><%= emp.getId() %></td>
                <td><%= emp.getName() %></td>
                <td><%= emp.getDesignation() %></td>
                <td><%= emp.getSalary() %></td>
                <td><%= emp.getJoiningDate() %></td>
                <td>
                    <a href="employee?action=edit&id=<%= emp.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                    <a href="employee?action=delete&id=<%= emp.getId() %>" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6" class="text-center text-danger">No employees found!</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
