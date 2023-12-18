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
                <li>                    
                    <a href="index.jsp">Home</a>                   
                </li>
                
                <li>
                    <a href="adminpanel.jsp">Admin Panel</a>
                </li>
                <li>
                    <a href="logout">Logout</a>
                </li>
            </ul>
        </div>
        
        <div class="hero">
            <h1>Welcome, <span id="username"><%= session.getAttribute("name") %></span></h1>
            <p>Discover your stay at our hotel</p>
        </div>
  
    </body>
</html>
