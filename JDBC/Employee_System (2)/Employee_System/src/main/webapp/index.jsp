<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f9f9f9; font-family: 'Segoe UI', sans-serif; }
        .container { margin-top: 50px; }
        h1 { color: #333; margin-bottom: 30px; }
        a.btn { font-weight: bold; }
    </style>
</head>
<body>
<div class="container text-center">
    <h1>Welcome to Employee Management</h1>
    <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary btn-lg">View Employee List</a>
</div>
</body>
</html>
