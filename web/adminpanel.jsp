<% 
    if(session.getAttribute("name") == null){
        response.sendRedirect("login.jsp");
    }
%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="./Styles/adminpanel.css">
</head>
    <body>
        <div class="sidebar">
            <nav class="nav">
                <button id="dashboard-btn" class="nav-item" onclick="showSection('dashboard')">Dashboard</button>
                <button id="rooms-btn" class="nav-item" onclick="showSection('rooms')">Rooms</button>
                <button id="employees-btn" class="nav-item" onclick="showSection('employees')">Employees</button>
                <button id="guests-btn" class="nav-item" onclick="showSection('guests')">Guests</button>
                <button id="transactions-btn" class="nav-item" onclick="showSection('transactions')">Transactions</button>
            </nav>
        </div>
        <div class="main-content">
            <header class="top-bar">
                <h1 class="page-title">Admin Panel</h1>
                 <a href="index.jsp" class="back-arrow"><-</a>
            </header>
           
            
            <div id="dashboard" class="content">Dashboard</div>
            <div id="rooms" class="content" style="display:none;">Rooms</div>
            
            <div id="employees" class="content" style="display:none;">
                Employees
                <a href="createEmployee.jsp">Create New Employee</a>

                <div class="table-container">
                    <table>
                        <tr>
                            <th>Employee Id</th>
                            <th>Name</th>
                            <th>Job Title</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>IsAdmin</th>
                            <th>Actions</th>
                        </tr>

                        <%System.out.println(request.getSession().getAttribute("employees"));%>
                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>${employee.employeeID}</td>
                                <td>${employee.fullName}</td>
                                <td>${employee.jobTitle}</td>
                                <td>${employee.email}</td>
                                <td>${employee.phoneNumber}</td>
                                <td>${employee.isAdmin}</td>
                                <td><a href="employee-update?employeeId=${employee.employeeID}">Edit</a></td>                               
                                <td><a href="#" onclick="deleteEmployee('${employee.employeeID}')">Delete</a>
</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
                
            <div id="guests" class="content" style="display:none;">Guests</div>
            <div id="transactions" class="content" style="display:none;">Transactions</div>
        </div>
        <script src="./Javascript/adminDisplaySection.js"></script>
    </body>
</html>

        
        
        
        
        