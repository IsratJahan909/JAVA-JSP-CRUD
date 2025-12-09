<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Inter', sans-serif;
            min-height: 100vh;
        }

        .header-bar {
            background: linear-gradient(135deg, #0d6efd, #6610f2);
            color: white;
            text-align: center;
            padding: 40px 0;
            border-bottom-left-radius: 40px;
            border-bottom-right-radius: 40px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        .header-bar h1 {
            font-weight: 700;
            margin: 0;
            letter-spacing: 1px;
        }

        .form-card {
            background-color: #fff;
            max-width: 600px;
            margin: 50px auto;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.08);
        }

        label {
            font-weight: 500;
            color: #333;
            margin-bottom: 5px;
        }

        input {
            border-radius: 10px !important;
            padding: 10px;
        }

        .btn-update {
            background: linear-gradient(135deg, #007bff, #00b4d8);
            border: none;
            color: white;
            font-weight: 600;
            padding: 10px 20px;
            border-radius: 12px;
            transition: 0.3s;
            width: 100%;
        }

        .btn-update:hover {
            background: linear-gradient(135deg, #00b4d8, #007bff);
            transform: translateY(-2px);
        }

        .btn-back {
            background-color: #6c757d;
            border: none;
            color: white;
            font-weight: 500;
            border-radius: 12px;
            padding: 10px 20px;
            text-decoration: none;
            transition: 0.3s;
        }

        .btn-back:hover {
            background-color: #5a6268;
        }

        .footer {
            text-align: center;
            color: #777;
            font-size: 14px;
            margin-top: 50px;
        }
    </style>
</head>

<body>

    <!-- Header Section -->
    <div class="header-bar">
        <h1>✏️ Edit Employee</h1>
        <p class="mb-0">Update employee information easily and professionally</p>
    </div>

    <!-- Form Card -->
    <div class="form-card">
        <form method="post" action="${pageContext.request.contextPath}/employees">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="${employee.id}"/>

            <div class="mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" value="${employee.name}" required/>
            </div>

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" value="${employee.email}" required/>
            </div>

            <div class="mb-3">
                <label>Department</label>
                <input type="text" name="department" class="form-control" value="${employee.department}" required/>
            </div>

            <div class="mb-3">
                <label>Salary</label>
                <input type="number" step="0.01" name="salary" class="form-control" value="${employee.salary}" required/>
            </div>

            <button type="submit" class="btn-update mb-3">💾 Update Employee</button>
            <div class="text-center">
                <a href="${pageContext.request.contextPath}/employees" class="btn-back">← Back to List</a>
            </div>
        </form>
    </div>

    <p class="footer">© 2025 Employee Management | Designed by IDB </p>

</body>
</html>
