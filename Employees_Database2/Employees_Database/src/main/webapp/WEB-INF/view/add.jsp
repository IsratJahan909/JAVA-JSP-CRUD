<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #f0f0f8, #c8e7ff);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .glass-form {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(15px);
            border-radius: 20px;
            padding: 30px;
            max-width: 500px;
            margin: 50px auto;
            box-shadow: 0 8px 32px rgba(0,0,0,0.25);
        }
        input, select {
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <div class="glass-form">
        <h2 class="text-center mb-4">Add New Employee</h2>
        <form action="employees?action=insert" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            <div class="mb-3">
                <label for="dob" class="form-label">DOB:</label>
                <input type="date" class="form-control" name="dob" required>
            </div>
            <div class="mb-3">
                <label for="department" class="form-label">Department:</label>
                <input type="text" class="form-control" name="department" required>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-success btn-lg me-2" value="Add Employee">
                <a href="employees" class="btn btn-secondary btn-lg">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
