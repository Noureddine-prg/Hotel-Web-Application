<% 
    if(session.getAttribute("name") == null){
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, <%= session.getAttribute("name") %></h1>
    </body>
</html>

<!--

First Hurdle: (1 Week Timeline) start day: Nov, 22

Login Page/Register Page -> Index(Home)  

-->

