<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #74ABE2, #5563DE);
            font-family: 'Poppins', sans-serif;
            color: white;
        }
        .container {
            margin-top: 150px;
            text-align: center;
        }
        h1 {
            font-size: 3rem;
            margin-bottom: 30px;
        }
        a {
            text-decoration: none;
            color: white;
        }
        .btn-custom {
            background-color: #ffcc00;
            color: #222;
            border-radius: 10px;
            padding: 15px 30px;
            transition: 0.3s;
            font-weight: bold;
        }
        .btn-custom:hover {
            background-color: #222;
            color: #ffcc00;
        }
    </style>
</head>
<body>
<div class="container">
    <h1> Product Management System </h1>
    <p>Manage your products smartly and beautifully </p>
    <a href="${pageContext.request.contextPath}/products" class="btn btn-custom">View Product List</a>
</div>
</body>
</html>
