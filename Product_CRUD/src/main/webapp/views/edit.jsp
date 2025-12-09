<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f1f5f9;
            font-family: 'Poppins', sans-serif;
        }
        .card {
            margin: 60px auto;
            max-width: 600px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
            border-radius: 12px;
        }
        .card-header {
            background: #ffc107;
            color: #000;
            text-align: center;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
<div class="card">
    <div class="card-header">️ Edit Product</div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/products" method="post">
            <input type="hidden" name="id" value="${product.id}"/>
            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <input type="text" name="name" class="form-control" value="${product.name}" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Price ($)</label>
                <input type="number" step="0.01" name="price" class="form-control" value="${product.price}" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" class="form-control" rows="3" required>${product.description}</textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Stock Quantity</label>
                <input type="number" name="stockQuantity" class="form-control" value="${product.stockQuantity}" required/>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-warning">Update Product</button>
                <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
