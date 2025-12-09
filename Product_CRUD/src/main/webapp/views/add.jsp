<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f8f9fa;
            font-family: 'Poppins', sans-serif;
        }
        .card {
            margin: 60px auto;
            max-width: 600px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.1);
            border-radius: 12px;
        }
        .card-header {
            background: #007bff;
            color: white;
            text-align: center;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
<div class="card">
    <div class="card-header"> Add New Product</div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/products" method="post">
            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <input type="text" name="name" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Price ($)</label>
                <input type="number" step="0.01" name="price" class="form-control" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" class="form-control" rows="3" required></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Stock Quantity</label>
                <input type="number" name="stockQuantity" class="form-control" required/>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Save Product</button>
                <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
