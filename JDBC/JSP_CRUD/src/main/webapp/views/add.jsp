<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Add Employee</title>
    </head>
    <body>
        <h1>Add Employee</h1>
        <form method="post" action="${pageContext.request.contextPath}/employees">
            <input type="hidden" name="action" value="create"/>
            <p>
                <label>Name:<br/><input type="text" name="name" required/></label>
            </p>
            <p>
                <label>Email:<br/><input type="email" name="email"/></label>
            </p>
            <p>
                <label>Department:<br/><input type="text" name="department"/></label>
            </p>
            <p>
                <label>Salary:<br/><input type="number" step="0.01" name="salary"/></label>
            </p>
            <p>
                <button type="submit">Save</button>
                <a href="${pageContext.request.contextPath}/employees">Cancel</a>
            </p>
        </form>
    </body>
</html>
