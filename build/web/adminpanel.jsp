<% 
    if(session.getAttribute("name") == null){
        response.sendRedirect("login.jsp");
    }
%>

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
                <button class="nav-item" onclick="showSection('dashboard')">Dashboard</button>
                <button class="nav-item" onclick="showSection('rooms')">Rooms</button>
                <button class="nav-item" onclick="showSection('employees')">Employees</button>
                <button class="nav-item" onclick="showSection('guests')">Guests</button>
                <button class="nav-item" onclick="showSection('transactions')">Transactions</button>
            </nav>
        </div>
        <div class="main-content">
            <header class="top-bar">
                <h1 class="page-title">Admin Panel</h1>
                 <a href="index.jsp" class="back-arrow"><-</a>
            </header>
            <div id="dashboard" class="content">Dashboard</div>
            <div id="rooms" class="content" style="display:none;">Rooms</div>
            <div id="employees" class="content" style="display:none;">Employees</div>
            <div id="guests" class="content" style="display:none;">Guests</div>
            <div id="transactions" class="content" style="display:none;">Transactions</div>
        </div>
        <script src="./Javascript/adminDisplaySection.js"></script>
    </body>
</html>

        
        
        
        
        