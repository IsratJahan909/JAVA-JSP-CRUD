
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abc.employee_system.entity.Employees"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f0f2f5; font-family: 'Segoe UI', sans-serif; }
        .container { margin-top: 50px; }
        table { background: #fff; }
        th, td { text-align: center; }
        h2 { margin-bottom: 20px; }
        .btn { margin: 2px; }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Employee List</h2>
    <div class="text-end mb-3">
        <a href="${pageContext.request.contextPath}/employees?action=add" class="btn btn-success">Add Employee</a>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Skills</th>
                <th>Full Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Employees> list = (List<Employees>) request.getAttribute("employees");
            if(list != null) {
                for(Employees e : list) {
        %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getName() %></td>
                <td><%= e.getDepartment() %></td>
                <td><%= e.getSalary() %></td>
                <td><%= e.getDob() %></td>
                <td><%= e.getGender() %></td>
                <td><%= e.getSkills() %></td>
                <td><%= e.getFullTime() ? "Yes" : "No" %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees?action=edit&id=<%= e.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees?action=delete&id=<%= e.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>

