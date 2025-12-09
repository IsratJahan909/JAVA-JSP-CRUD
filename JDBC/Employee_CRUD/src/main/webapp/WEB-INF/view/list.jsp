<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f7f9fc;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 1000px;
            margin: 60px auto;
            background: #fff;
            border-radius: 10px;
            padding: 25px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        .top-bar {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 15px;
        }

        .btn {
            text-decoration: none;
            color: #fff;
            padding: 8px 12px;
            border-radius: 5px;
            font-weight: bold;
            transition: 0.2s;
        }

        .btn:hover {
            opacity: 0.8;
        }

        .btn-add {
            background-color: #28a745;
        }

        .btn-edit {
            background-color: #ffc107;
            color: #000;
        }

        .btn-delete {
            background-color: #dc3545;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f2f6ff;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Employee List</h2>

    <div class="top-bar">
        <a href="${pageContext.request.contextPath}/employees?action=new" class="btn btn-add">+ Add Employee</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${employeeList}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.dob}</td>
                <td>${emp.department}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees?action=edit&id=${emp.id}" class="btn btn-edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees?action=delete&id=${emp.id}"
                       class="btn btn-delete"
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty employeeList}">
        <p style="text-align:center; margin-top:15px; color:#777;">No employees found!</p>
    </c:if>

</div>

</body>
</html>
