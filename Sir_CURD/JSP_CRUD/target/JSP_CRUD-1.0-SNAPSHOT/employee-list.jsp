<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employee List</h2>
<a href="employees?action=new">Add New Employee</a>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Department</th><th>Salary</th>
        <th>DOB</th><th>Gender</th><th>Skills</th><th>Full Time</th><th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>${emp.dob}</td>
            <td>${emp.gender}</td>
            <td>${emp.skills}</td>
            <td>${emp.fullTime ? 'Yes' : 'No'}</td>
            <td>
                <a href="employees?action=edit&id=${emp.id}">Edit</a> |
                <a href="employees?action=delete&id=${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
