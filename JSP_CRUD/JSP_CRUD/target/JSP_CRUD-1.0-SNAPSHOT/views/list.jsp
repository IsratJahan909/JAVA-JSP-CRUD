<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>

    <!-- Bootstrap CSS -->
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
            background: linear-gradient(135deg, #007bff, #6610f2);
            color: white;
            padding: 40px 0;
            text-align: center;
            border-bottom-left-radius: 40px;
            border-bottom-right-radius: 40px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        .header-bar h1 {
            font-weight: 700;
            letter-spacing: 1px;
        }

        .card {
            border: none;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.08);
        }

        .table thead {
            background-color: #007bff;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
        }

        .table tbody tr:hover {
            background-color: #f1f7ff;
            transform: scale(1.01);
            transition: all 0.15s ease-in-out;
        }

        .btn-add {
            background: linear-gradient(135deg, #00c6ff, #0072ff);
            border: none;
            color: white;
            font-weight: 500;
            padding: 10px 20px;
            border-radius: 12px;
            transition: 0.3s;
            box-shadow: 0 3px 8px rgba(0,0,0,0.2);
        }

        .btn-add:hover {
            background: linear-gradient(135deg, #0072ff, #00c6ff);
            transform: translateY(-2px);
        }

        .action-btn {
            border: none;
            border-radius: 10px;
            padding: 6px 12px;
            font-size: 14px;
            font-weight: 500;
            transition: 0.3s;
        }

        .btn-edit {
            background-color: #198754;
            color: #fff;
        }

        .btn-edit:hover {
            background-color: #157347;
        }

        .btn-delete {
            background-color: #dc3545;
            color: #fff;
        }

        .btn-delete:hover {
            background-color: #bb2d3b;
        }

        .footer {
            text-align: center;
            color: #6c757d;
            font-size: 14px;
            margin-top: 50px;
        }
    </style>
</head>

<body>

    <div class="header-bar">
        <h1>Employee Management System</h1>
        <p class="lead mb-0">Manage your team efficiently and professionally</p>
    </div>

    <div class="container mt-5 mb-5">
        <div class="card p-4">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h4 class="fw-bold text-secondary mb-0">Employee List</h4>
                <a href="${pageContext.request.contextPath}/employees?action=add" class="btn-add">
                    ➕ Add Employee
                </a>
            </div>

            <div class="table-responsive">
                <table class="table table-hover align-middle text-center">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>Salary</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${employees}">
                            <tr>
                                <td>${e.id}</td>
                                <td>${e.name}</td>
                                <td>${e.email}</td>
                                <td>${e.department}</td>
                                <td>$${e.salary}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/employees?action=edit&id=${e.id}"
                                       class="action-btn btn-edit me-2">Edit</a>
                                    <a href="${pageContext.request.contextPath}/employees?action=delete&id=${e.id}"
                                       class="action-btn btn-delete"
                                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <p class="footer">© 2025 Employee Portal | Designed by IDB </p>

</body>
</html>
