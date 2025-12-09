<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f2f6fc;
            font-family: 'Poppins', sans-serif;
        }
        .table {
            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
        }
        .btn-add {
            background: #28a745;
            color: white;
            border-radius: 8px;
        }
        .btn-edit {
            background: #ffc107;
            color: black;
            border-radius: 8px;
        }
        .btn-delete {
            background: #dc3545;
            color: white;
            border-radius: 8px;
        }
        .btn:hover { opacity: 0.8; }
        h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h2>Product List</h2>
    <div class="text-end mb-3">
        <a href="${pageContext.request.contextPath}/products?action=add" class="btn btn-add"> Add New Product</a>
    </div>

    <table class="table table-bordered table-striped align-middle">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price ($)</th>
            <th>Description</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.description}</td>
                <td>${p.stockQuantity}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/products?action=edit&id=${p.id}" class="btn btn-edit btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/products?action=delete&id=${p.id}" class="btn btn-delete btn-sm" onclick="return confirm('Delete this product?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
