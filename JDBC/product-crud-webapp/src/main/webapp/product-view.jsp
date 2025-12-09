<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.servlet.jsp.jstl.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Product</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .product-details { border: 1px solid #ccc; padding: 20px; max-width: 400px; }
        .product-details h2 { margin-top: 0; }
        .product-details p { margin: 5px 0; }
        .product-details strong { display: inline-block; width: 120px; }
    </style>
</head>
<body>
    <h1>Product Details</h1>

    <c:if test="${product != null}">
        <div class="product-details">
            <h2><c:out value="${product.name}" /></h2>
            <p><strong>ID:</strong> <c:out value="${product.id}" /></p>
            <p><strong>Price:</strong> $<c:out value="${product.price}" /></p>
            <p><strong>Stock:</strong> <c:out value="${product.stockQuantity}" /></p>
            <p><strong>Description:</strong> <c:out value="${product.description}" /></p>
        </div>
        <p>
            <a href="products?action=edit&id=<c:out value='${product.id}' />">Edit</a> |
            <a href="products">Back to List</a>
        </p>
    </c:if>
    <c:if test="${product == null}">
        <p>Product not found.</p>
        <p><a href="products">Back to List</a></p>
    </c:if>
</body>
</html>
