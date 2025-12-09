<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP CRUD - Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary: #4361ee;
            --secondary: #3f37c9;
            --success: #4cc9f0;
            --light: #f8f9fa;
            --dark: #212529;
            --card-shadow: 0 5px 15px rgba(0,0,0,0.06);
            --hover-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }
        
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #e4edf5 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        
        .navbar {
            background: linear-gradient(to right, var(--primary), var(--secondary));
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            padding: 0.5rem 0;
            min-height: 50px;
        }
        
        .navbar-brand {
            font-weight: 600;
            font-size: 1.2rem;
            display: flex;
            align-items: center;
            gap: 8px;
        }
        
        .nav-link {
            font-weight: 500;
            padding: 0.4rem 0.8rem !important;
            border-radius: 6px;
            transition: all 0.2s ease;
            margin: 0 3px;
            font-size: 0.9rem;
        }
        
        .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.15);
            transform: translateY(-1px);
        }
        
        .container {
            margin-top: 30px;
            padding-bottom: 30px;
        }
        
        .hero-card {
            background: white;
            border-radius: 14px;
            box-shadow: var(--card-shadow);
            overflow: hidden;
            transition: all 0.2s ease;
            border: none;
            margin-bottom: 20px;
        }
        
        .hero-card:hover {
            transform: translateY(-4px);
            box-shadow: var(--hover-shadow);
        }
        
        .hero-header {
            background: linear-gradient(to right, var(--primary), var(--secondary));
            color: white;
            padding: 1.5rem 1.5rem;
            text-align: center;
        }
        
        .hero-body {
            padding: 1.8rem 1.5rem;
        }
        
        .action-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 15px;
            margin-top: 15px;
        }
        
        .action-card {
            background: white;
            border-radius: 12px;
            padding: 18px;
            text-align: center;
            box-shadow: var(--card-shadow);
            transition: all 0.2s ease;
            border: 1px solid rgba(0,0,0,0.04);
            display: flex;
            flex-direction: column;
            height: 100%;
        }
        
        .action-card:hover {
            transform: translateY(-3px);
            box-shadow: var(--hover-shadow);
        }
        
        .action-icon {
            font-size: 1.8rem;
            margin-bottom: 10px;
            color: var(--primary);
        }
        
        .action-card h4 {
            font-weight: 600;
            margin-bottom: 8px;
            color: var(--dark);
            font-size: 1.1rem;
        }
        
        .action-card p {
            color: #6c757d;
            flex-grow: 1;
            font-size: 0.85rem;
            line-height: 1.4;
        }
        
        .btn-modern {
            border-radius: 8px;
            padding: 8px 16px;
            font-weight: 500;
            transition: all 0.2s ease;
            border: none;
            margin-top: 10px;
            font-size: 0.85rem;
        }
        
        .btn-primary-modern {
            background: linear-gradient(to right, var(--primary), var(--secondary));
            color: white;
        }
        
        .btn-primary-modern:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(67, 97, 238, 0.25);
        }
        
        .btn-success-modern {
            background: linear-gradient(to right, #4cc9f0, #4895ef);
            color: white;
        }
        
        .btn-success-modern:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(76, 201, 240, 0.25);
        }
        
        .welcome-text {
            font-size: 0.95rem;
            color: #6c757d;
            max-width: 550px;
            margin: 0 auto 20px;
            line-height: 1.5;
        }
        
        .stats-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin: 20px 0;
            flex-wrap: wrap;
        }
        
        .stat-item {
            text-align: center;
            padding: 12px 18px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 3px 8px rgba(0,0,0,0.05);
            min-width: 120px;
        }
        
        .stat-value {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
            margin-bottom: 3px;
        }
        
        .stat-label {
            font-size: 0.8rem;
            color: #6c757d;
        }
        
        h1 {
            font-size: 1.6rem;
            margin-bottom: 0.5rem;
        }
        
        .lead {
            font-size: 0.95rem;
        }
        
        @media (max-width: 768px) {
            .action-grid {
                grid-template-columns: 1fr;
            }
            
            .hero-body {
                padding: 1.5rem 1.2rem;
            }
            
            .stats-container {
                gap: 12px;
            }
            
            .stat-item {
                min-width: 100px;
                padding: 10px 12px;
            }
            
            .hero-header {
                padding: 1.2rem 1.2rem;
            }
        }
    </style>
</head>
<body>

    <!-- Compact Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark sticky-top">
        <div class="container">
            <a class="navbar-brand" href="/JSP_CRUD/">
                <i class="fas fa-database"></i>
                JSP CRUD
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="employees">
                            <i class="fas fa-users me-1"></i> Employees
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="department">
                            <i class="fas fa-building me-1"></i> Departments
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main content -->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <!-- Hero Card -->
                <div class="hero-card">
                    <div class="hero-header">
                        <h1 class="fw-bold">JSP CRUD Application</h1>
                        <p class="lead mb-0">Streamlined Employee & Department Management</p>
                    </div>
                    <div class="hero-body">
                        <p class="welcome-text">
                            Manage your organization's employees and departments with our intuitive CRUD application. 
                            Add, view, edit, and delete records with ease using this modern web interface.
                        </p>
                        
                        <!-- Stats Section -->
                        <div class="stats-container">
                            <div class="stat-item">
                                <div class="stat-value">${employeeCount}</div>
                                <div class="stat-label">Employees</div>
                            </div>
                            <div class="stat-item">
                                <div class="stat-value">${departmentCount}</div>
                                <div class="stat-label">Departments</div>
                            </div>
                            <div class="stat-item">
                                <div class="stat-value">24/7</div>
                                <div class="stat-label">Availability</div>
                            </div>
                        </div>
                        
                        <!-- Action Grid -->
                        <div class="action-grid">
                            <div class="action-card">
                                <div class="action-icon">
                                    <i class="fas fa-users"></i>
                                </div>
                                <h4>View Employees</h4>
                                <p>Browse and search through all employee records in your organization.</p>
                                <a href="employees" class="btn btn-primary-modern btn-modern">View Employees</a>
                            </div>
                            
                            <div class="action-card">
                                <div class="action-icon">
                                    <i class="fas fa-user-plus"></i>
                                </div>
                                <h4>Add Employee</h4>
                                <p>Create a new employee record with detailed information and department assignment.</p>
                                <a href="employees?action=add" class="btn btn-success-modern btn-modern">Add Employee</a>
                            </div>
                            
                            <div class="action-card">
                                <div class="action-icon">
                                    <i class="fas fa-building"></i>
                                </div>
                                <h4>View Departments</h4>
                                <p>Explore all departments and their details within your organization.</p>
                                <a href="department" class="btn btn-primary-modern btn-modern">View Departments</a>
                            </div>
                            
                            <div class="action-card">
                                <div class="action-icon">
                                    <i class="fas fa-plus-circle"></i>
                                </div>
                                <h4>Add Department</h4>
                                <p>Create a new department to organize your employees and structure.</p>
                                <a href="department?action=add" class="btn btn-success-modern btn-modern">Add Department</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>