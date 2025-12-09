<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.servlet.jsp.jstl.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        <c:choose>
            <c:when test="${product != null}">
                Edit Product
            </c:when>
            <c:otherwise>
                New Product
            </c:otherwise>
        </c:choose>
    </title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { max-width: 400px; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"], textarea { width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        input[type="submit"] { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <h1>
        <c:choose>
            <c:when test="${product != null}">
                Edit Product
            </c:when>
            <c:otherwise>
                New Product
            </c:otherwise>
        </c:choose>
    </h1>

    <form action="products" method="POST">
        <c:if test="${product != null}">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        </c:if>
        <c:if test="${product == null}">
            <input type="hidden" name="action" value="insert" />
        </c:if>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<c:out value='${product.name}' />" required />

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" value="<c:out value='${product.price}' />" required />

        <label for="description">Description:</label>
        <textarea id="description" name="description"><c:out value='${product.description}' /></textarea>

        <label for="stockQuantity">Stock Quantity:</label>
        <input type="number" id="stockQuantity" name="stockQuantity" value="<c:out value='${product.stockQuantity}' />" required />

        <input type="submit" value="Save" />
        <a href="products">Cancel</a>
    </form>
</body>
</html>
