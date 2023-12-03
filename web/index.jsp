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
            <div class="logo">HotelName</div>
                <ul class="navbar_links">
                    <li>Home</li>
                    <li>About</li>
                    <li>Contact</li>
                    <li>Logout</li>
                </ul>
        </div>
        
        <div class="hero">
            <h1>Welcome, <span id="username"></span><%= session.getAttribute("name")%></h1>
            <p>Discover your perfect stay at our hotel.</p>
        </div>

        
        <div class="footer">
            <p>&copy; 2023 HotelName. All rights reserved.</p>
        </div>
</body>
</html>


<!--

First Hurdle: (1 Week Timeline) start day: Nov, 22

Login Page/Register Page -> Index(Home)  

Done Dec. 2

-->