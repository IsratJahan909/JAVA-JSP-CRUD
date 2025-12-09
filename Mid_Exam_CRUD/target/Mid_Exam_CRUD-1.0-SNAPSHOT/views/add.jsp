<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center text-primary mb-4">Add New Employee</h2>

    <form action="employee?action=insert" method="post" class="card p-4 shadow rounded bg-white">
        <div class="mb-3">
            <label class="form-label">Employee Name:</label>
            <input type="text" name="name" class="form-control" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Designation:</label>
            <input type="text" name="designation" class="form-control" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Salary:</label>
            <input type="number" name="salary" class="form-control" step="0.01" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Joining Date:</label>
            <input type="date" name="joiningDate" class="form-control" required/>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success px-5">Save</button>
            <a href="employee" class="btn btn-warning px-4">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
