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
            
            <!-- Rooms Section -->
            <div id="rooms" class="content" style="display:none;">Rooms</div>
                      
            <!-- Employee Section -->
            <div id="employees" class="content" style="display:none;">
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

                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>${employee.employeeID}</td>
                                <td>${employee.fullName}</td>
                                <td>${employee.jobTitle}</td>
                                <td>${employee.email}</td>
                                <td>${employee.phoneNumber}</td>
                                <td>${employee.isAdmin}</td>
                                <td><a href="${pageContext.request.contextPath}/employee-get?action=employee-get&employeeId=${employee.employeeID}">Edit</a></td>                        
                                
                                <td>
                                    
                                <form action="employee-delete" method="post">
                                    <input type="hidden" name="employeeId" value="${employee.employeeID}">
                                    <input type="hidden" name="action" value="delete">
                                    <button type="submit">Delete</button>
                                </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            
            <!-- Guest Section -->
            <div id="guests" class="content" style="display:none;">Guests</div>
            
            <!-- Transaction Section -->
            <div id="transactions" class="content" style="display:none;">Transactions</div>
        </div>
        <script src="./Javascript/adminDisplaySection.js"></script>
    </body>
</html>

        
        
        
        
        