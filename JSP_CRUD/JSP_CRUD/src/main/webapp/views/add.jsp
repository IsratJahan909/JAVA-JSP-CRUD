<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee - Employee Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .form-container {
            max-width: 600px;
            width: 100%;
            animation: fadeInUp 0.8s ease-out;
        }

        .card {
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.4);
            border: none;
            overflow: hidden;
            background: white;
        }

        .card-header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .card-header h1 {
            font-size: 2rem;
            font-weight: 700;
            margin: 0;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }

        .card-header i {
            font-size: 3rem;
            margin-bottom: 15px;
            display: block;
        }

        .card-body {
            padding: 40px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        .form-label {
            display: block;
            font-weight: 600;
            color: #333;
            margin-bottom: 8px;
            font-size: 0.95rem;
        }

        .form-label i {
            color: #667eea;
            margin-right: 8px;
            width: 20px;
            text-align: center;
        }

        .form-control {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e9ecef;
            border-radius: 10px;
            font-size: 1rem;
            transition: all 0.3s ease;
            font-family: inherit;
        }

        .form-control:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
            transform: translateY(-2px);
        }

        .form-control::placeholder {
            color: #adb5bd;
            font-style: italic;
        }

        .button-group {
            display: flex;
            gap: 15px;
            justify-content: space-between;
            margin-top: 35px;
        }

        .btn {
            padding: 14px 35px;
            border: none;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }

        .btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }

        .btn:active {
            transform: translateY(-1px);
        }

        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            flex: 1;
        }

        .btn-primary:hover {
            background: linear-gradient(135deg, #5568d3 0%, #65408b 100%);
        }

        .btn-secondary {
            background: linear-gradient(135deg, #6c757d 0%, #5a6268 100%);
            color: white;
            flex: 1;
        }

        .btn-secondary:hover {
            background: linear-gradient(135deg, #5a6268 0%, #4e555b 100%);
        }

        .required {
            color: #dc3545;
            margin-left: 3px;
        }

        .info-text {
            background: linear-gradient(135deg, #e3f2fd 0%, #e1f5fe 100%);
            padding: 15px;
            border-radius: 10px;
            margin-bottom: 25px;
            border-left: 4px solid #2196f3;
        }

        .info-text p {
            margin: 0;
            color: #01579b;
            font-size: 0.9rem;
        }

        .info-text i {
            color: #2196f3;
            margin-right: 8px;
        }

        /* Responsive Design */
        @media (max-width: 576px) {
            .card-body {
                padding: 25px;
            }

            .card-header h1 {
                font-size: 1.5rem;
            }

            .button-group {
                flex-direction: column;
            }

            .btn {
                width: 100%;
            }
        }

        /* Input validation styles */
        .form-control:invalid:not(:placeholder-shown) {
            border-color: #dc3545;
        }

        .form-control:valid:not(:placeholder-shown) {
            border-color: #28a745;
        }

        /* Loading animation for submit button */
        .btn-primary:active::after {
            content: '';
            display: inline-block;
            width: 14px;
            height: 14px;
            border: 2px solid white;
            border-top-color: transparent;
            border-radius: 50%;
            animation: spin 0.8s linear infinite;
            margin-left: 8px;
        }

        @keyframes spin {
            to { transform: rotate(360deg); }
        }
    </style>
</head>
<body>
    <div class="form-container">
        <div class="card">
            <div class="card-header">
                <i class="fas fa-user-plus"></i>
                <h1>Add New Employee</h1>
            </div>
            <div class="card-body">
                <div class="info-text">
                    <p>
                        <i class="fas fa-info-circle"></i>
                        <strong>Note:</strong> Fields marked with <span class="required">*</span> are required.
                    </p>
                </div>

                <form method="post" action="${pageContext.request.contextPath}/employees">
                    <input type="hidden" name="action" value="create"/>
                    
                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-user"></i>
                            Name <span class="required">*</span>
                        </label>
                        <input type="text" 
                               name="name" 
                               class="form-control" 
                               placeholder="Enter employee name" 
                               required 
                               minlength="2"
                               maxlength="100"/>
                    </div>

                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-envelope"></i>
                            Email
                        </label>
                        <input type="email" 
                               name="email" 
                               class="form-control" 
                               placeholder="employee@example.com"/>
                    </div>

                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-building"></i>
                            Department
                        </label>
                        <input type="text" 
                               name="department" 
                               class="form-control" 
                               placeholder="e.g., IT, HR, Finance"/>
                    </div>

                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-money-bill-wave"></i>
                            Salary
                        </label>
                        <input type="number" 
                               step="0.01" 
                               name="salary" 
                               class="form-control" 
                               placeholder="e.g., 50000.00"
                               min="0"/>
                    </div>

                    <div class="button-group">
                        <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">
                            <i class="fas fa-times"></i>
                            Cancel
                        </a>
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-save"></i>
                            Save Employee
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
