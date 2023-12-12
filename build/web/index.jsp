<% 
    if(session.getAttribute("name") == null){
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Landing Page</title>
        <link rel="stylesheet" href="Styles/index.css">
    </head>
    
    <body>
        <div class="navbar">
            <div class="logo">Hotel</div>
            <ul class="navbar_links">
                <li> Home </li>
                <li>
                    <a href="adminpanel.jsp" class="">Admin Panel</a>
                </li>
                <li>Book Room</li>
                <li>Cart</li>
                <li>
                    <a href="logout" class="logout">Logout</a>
                </li>
            </ul>
        </div>
        
        <div class="hero">
            <h1>Welcome, <span id="username"></span><%= session.getAttribute("name")%></h1>
            <p>Discover your stay at our hotel.</p>
        </div>

        
        <div class="footer">
            <p>&copy; 2023 Hotel. All rights reserved.</p>
        </div>
</body>
</html>



