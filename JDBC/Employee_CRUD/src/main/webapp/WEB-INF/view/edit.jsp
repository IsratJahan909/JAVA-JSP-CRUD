<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abc.employee_crud.entity.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f2f5fa;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 600px;
            margin: 60px auto;
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input {
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 15px;
        }

        input:focus {
            border-color: #007bff;
            outline: none;
        }

        .btn {
            text-decoration: none;
            color: white;
            padding: 10px;
            text-align: center;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn-update {
            background-color: #007bff;
        }

        .btn-update:hover {
            opacity: 0.85;
        }

        .btn-back {
            background-color: #6c757d;
        }

        .btn-back:hover {
            opacity: 0.85;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Edit Employee</h2>

    <form action="${pageContext.request.contextPath}/employees?action=update" method="post">
        <input type="hidden" name="id" value="<%= emp.getId() %>">

        <div>
            <label for="name">Employee Name</label>
            <input type="text" id="name" name="name" value="<%= emp.getName() %>" required>
        </div>

        <div>
            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="dob" value="<%= emp.getDob() %>" required>
        </div>

        <div>
            <label for="department">Department</label>
            <input type="text" id="department" name="department" value="<%= emp.getDepartment() %>" required>
        </div>

        <div class="action-buttons">
            <button type="submit" class="btn btn-update">🔁 Update</button>
            <a href="${pageContext.request.contextPath}/employees" class="btn btn-back">← Back</a>
        </div>
    </form>
</div>

</body>
</html>
