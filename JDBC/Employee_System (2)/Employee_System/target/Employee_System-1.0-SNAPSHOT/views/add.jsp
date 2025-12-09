<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { 
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            min-height: 100vh;
            padding: 20px;
        }
        .container { 
            max-width: 600px; 
            margin-top: 30px; 
            background: #fff; 
            padding: 30px; 
            border-radius: 15px; 
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        h2 { 
            margin-bottom: 25px; 
            text-align: center; 
            color: #333;
            font-weight: 600;
        }
        .form-label {
            font-weight: 500;
            color: #555;
            margin-bottom: 8px;
        }
        .btn-submit {
            background: linear-gradient(135deg, #28a745, #20c997);
            border: none;
            padding: 12px;
            font-weight: 600;
            font-size: 1.1rem;
        }
        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
        }
        .form-control, .form-select {
            border-radius: 8px;
            padding: 10px 15px;
            border: 2px solid #e9ecef;
            transition: all 0.3s;
        }
        .form-control:focus, .form-select:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
        }
        .form-check-input:checked {
            background-color: #667eea;
            border-color: #667eea;
        }
        .header-icon {
            text-align: center;
            font-size: 2.5rem;
            margin-bottom: 10px;
            color: #667eea;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header-icon">
        <i class="fas fa-user-plus"></i>
    </div>
    <h2>Add New Employee</h2>
    
    <form action="${pageContext.request.contextPath}/employees" method="post">
        <!-- Name Field -->
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" name="name" class="form-control" placeholder="Enter employee name" required>
        </div>

       
        <div class="mb-3">
            <label class="form-label">Department</label>
            <select name="department" class="form-select" required>
                <option value="">Select Department</option>
                <option value="Engineering">Engineering</option>
                <option value="Marketing">Marketing</option>
                <option value="Sales">Sales</option>
                <option value="Human Resources">Human Resources</option>
                <option value="Finance">Finance</option>
                <option value="Operations">Operations</option>
                <option value="IT">IT</option>
                <option value="Customer Support">Customer Support</option>
            </select>
        </div>

        <!-- Salary Field -->
        <div class="mb-3">
            <label class="form-label">Salary</label>
            <input type="number" step="0.01" name="salary" class="form-control" placeholder="Enter salary amount" required>
        </div>

        <!-- Date of Birth -->
        <div class="mb-3">
            <label class="form-label">Date of Birth</label>
            <input type="date" name="dob" class="form-control" required>
        </div>

        <!-- Gender Radio Buttons -->
        <div class="mb-3">
            <label class="form-label">Gender</label>
            <div class="d-flex gap-4">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Male" id="male">
                    <label class="form-check-label" for="male">
                        Male
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Female" id="female">
                    <label class="form-check-label" for="female">
                        Female
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Other" id="other">
                    <label class="form-check-label" for="other">
                        Other
                    </label>
                </div>
            </div>
        </div>

        <!-- Skills -->
        <div class="mb-3">
            <label class="form-label">Skills</label>
            <input type="text" name="skills" class="form-control" placeholder="e.g., Java, Python, Project Management">
            <div class="form-text">Enter skills separated by commas</div>
        </div>

        <!-- Full Time Checkbox -->
        <div class="mb-4 form-check">
            <input type="checkbox" name="fullTime" class="form-check-input" id="fullTime">
            <label class="form-check-label" for="fullTime">
                Full Time Employee
            </label>
        </div>

        <!-- Buttons -->
        <button type="submit" class="btn btn-submit w-100 mb-2">
            <i class="fas fa-save me-2"></i>Add Employee
        </button>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-outline-secondary w-100">
            <i class="fas fa-arrow-left me-2"></i>Back to List
        </a>
    </form>
</div>

<!-- Font Awesome for icons -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>