<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Employees</title>
        <style>
            body{
                font-family: Arial, sans-serif;
                margin:30px;
            }
            table{
                border-collapse:collapse;
                width:100%;
            }
            th,td{
                padding:8px;
                border:1px solid #ddd;
            }
            th{
                background:#f4f4f4;
            }
            .actions a{
                margin-right:6px;
            }
        </style>
    </head>
    <body>
        ${employees.size()}
        <h1>Employees</h1>
        <p><a href="${pageContext.request.contextPath}/employees?action=add">Add New Employee</a></p>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Dept</th>
                <th>Salary</th>
                <th>Actions</th>
            </tr>
            
            <c:forEach var="e" items="${employees}">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.email}</td>
                    <td>${e.department}</td>
                    <td>${e.salary}</td>
                    <td class="actions">
                        <a href="${pageContext.request.contextPath}/employees?action=edit&id=${e.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/employees?action=delete&id=${e.id}"
                           onclick="return confirm('Delete this employee?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
