<% 
    if(session.getAttribute("name") == null){
        response.sendRedirect("registration.jsp");
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
        <h1>Hello this is the index page.</h1>
    </body>
</html>

<!--

First Hurdle: (1 Week Timeline) start day: Nov, 22

Login Page/Register Page || Add check admin option  -> Index(Home)  

-->

