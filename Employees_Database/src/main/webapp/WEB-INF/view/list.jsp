<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.israt.employees_database.entity.employees" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #f0f0f8, #c8e7ff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .glass {
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            padding: 20px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
        }
        table th, table td {
            text-align: center;
        }
        a.btn {
            margin-right: 5px;
        }
    </style>
</head>
<body class="container mt-5">
    <div class="glass">
        <h2 class="text-center mb-4">Employee List</h2>
        <div class="mb-3 text-center">
            <a href="${pageContext.request.contextPath}/employees?action=new" class="btn btn-primary btn-lg">Add New Employee</a>
        </div>

        <table class="table table-bordered table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<employees> list = (List<employees>)request.getAttribute("employeeList");
                if (list == null || list.isEmpty()) {
            %>
                <tr>
                    <td colspan="5">No employees found.</td>
                </tr>
            <%
                } else {
                    for(employees emp : list) {
            %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getDob() != null ? emp.getDob().toString() : "" %></td>
                    <td><%= emp.getDepartment() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employees?action=edit&id=<%=emp.getId()%>" class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/employees?action=delete&id=<%=emp.getId()%>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
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
