<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>
    <form method="post" action="${pageContext.request.contextPath}/employees">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${employee.id}"/>
        <p>
            <label>Name:<br/><input type="text" name="name" value="${employee.name}" required/></label>
        </p>
        <p>
            <label>Email:<br/><input type="email" name="email" value="${employee.email}"/></label>
        </p>
        <p>
            <label>Department:<br/><input type="text" name="department" value="${employee.department}"/></label>
        </p>
        <p>
            <label>Salary:<br/><input type="number" step="0.01" name="salary" value="${employee.salary}"/></label>
        </p>
        <p>
            <button type="submit">Update</button>
            <a href="${pageContext.request.contextPath}/employees">Back</a>
        </p>
    </form>
</body>
</html>
