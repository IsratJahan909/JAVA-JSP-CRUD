<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abc.employee_system.entity.Employees" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
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
        .btn-update {
            background: linear-gradient(135deg, #ffc107, #fd7e14);
            border: none;
            padding: 12px;
            font-weight: 600;
            font-size: 1.1rem;
            color: white;
        }
        .btn-update:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 193, 7, 0.3);
            color: white;
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
        .gender-group {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        Employees emp = (Employees) request.getAttribute("employee");
        if(emp == null){
            response.sendRedirect(request.getContextPath()+"/employees");
            return;
        }
    %>
    
    <div class="header-icon">
        <i class="fas fa-user-edit"></i>
    </div>
    <h2>Edit Employee</h2>
    
    <form action="${pageContext.request.contextPath}/employees" method="post">
        <input type="hidden" name="id" value="<%= emp.getId() %>">
        <input type="hidden" name="action" value="update">

        <!-- Name Field -->
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" name="name" class="form-control" value="<%= emp.getName() != null ? emp.getName() : "" %>" placeholder="Enter employee name" required>
        </div>

        <!-- Department Dropdown -->
        <div class="mb-3">
            <label class="form-label">Department</label>
            <select name="department" class="form-select" required>
                <option value="">Select Department</option>
                <option value="Engineering" <%= "Engineering".equals(emp.getDepartment()) ? "selected" : "" %>>Engineering</option>
                <option value="Marketing" <%= "Marketing".equals(emp.getDepartment()) ? "selected" : "" %>>Marketing</option>
                <option value="Sales" <%= "Sales".equals(emp.getDepartment()) ? "selected" : "" %>>Sales</option>
                <option value="Human Resources" <%= "Human Resources".equals(emp.getDepartment()) ? "selected" : "" %>>Human Resources</option>
                <option value="Finance" <%= "Finance".equals(emp.getDepartment()) ? "selected" : "" %>>Finance</option>
                <option value="Operations" <%= "Operations".equals(emp.getDepartment()) ? "selected" : "" %>>Operations</option>
                <option value="IT" <%= "IT".equals(emp.getDepartment()) ? "selected" : "" %>>IT</option>
                <option value="Customer Support" <%= "Customer Support".equals(emp.getDepartment()) ? "selected" : "" %>>Customer Support</option>
                <option value="Research & Development" <%= "Research & Development".equals(emp.getDepartment()) ? "selected" : "" %>>Research & Development</option>
                <option value="Quality Assurance" <%= "Quality Assurance".equals(emp.getDepartment()) ? "selected" : "" %>>Quality Assurance</option>
            </select>
        </div>

        <!-- Salary Field -->
        <div class="mb-3">
            <label class="form-label">Salary</label>
      <input type="number" step="0.01" name="salary" class="form-control" 
      placeholder="Enter salary amount" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Date of Birth</label>
            <input type="date" name="dob" class="form-control" value="<%= emp.getDob() != null ? emp.getDob() : "" %>" required>
        </div>

        <!-- Gender Radio Buttons -->
        <div class="mb-3">
            <label class="form-label">Gender</label>
            <div class="gender-group">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Male" id="male" <%= "Male".equals(emp.getGender()) ? "checked" : "" %>>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Female" id="female" <%= "Female".equals(emp.getGender()) ? "checked" : "" %>>
                    <label class="form-check-label" for="female">Female</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Other" id="other" <%= "Other".equals(emp.getGender()) ? "checked" : "" %>>
                    <label class="form-check-label" for="other">Other</label>
                </div>
            </div>
        </div>

        <!-- Skills -->
        <div class="mb-3">
            <label class="form-label">Skills</label>
            <input type="text" name="skills" class="form-control" value="<%= emp.getSkills() != null ? emp.getSkills() : "" %>" placeholder="e.g., Java, Python, Project Management">
            <div class="form-text">Enter skills separated by commas</div>
        </div>

        <!-- Full Time Checkbox -->
        <div class="mb-4 form-check">
            <input type="checkbox" name="fullTime" class="form-check-input" id="fullTime" <%= emp.getFullTime() != null && emp.getFullTime() ? "checked" : "" %>>
            <label class="form-check-label" for="fullTime">Full Time Employee</label>
        </div>

        <!-- Buttons -->
        <button type="submit" class="btn btn-update w-100 mb-2">
            <i class="fas fa-save me-2"></i>Update Employee
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