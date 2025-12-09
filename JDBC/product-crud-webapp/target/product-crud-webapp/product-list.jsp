<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.servlet.jsp.jstl.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .action-link { margin-right: 10px; }
    </style>
</head>
<body>
    <h1>Product List</h1>
    <p><a href="products?action=new">Add New Product</a></p>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.stockQuantity}" /></td>
                    <td>
                        <a href="products?action=view&id=<c:out value='${product.id}' />" class="action-link">View</a>
                        <a href="products?action=edit&id=<c:out value='${product.id}' />" class="action-link">Edit</a>
                        <a href="products?action=delete&id=<c:out value='${product.id}' />" onclick="return confirm('Are you sure you want to delete this product?')" class="action-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
