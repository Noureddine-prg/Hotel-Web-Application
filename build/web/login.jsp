
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Login</title>
        <link rel="stylesheet" href="Styles/login.css"> 
    </head>
    
    <body>
        <div class="login-container">
            <form method="post" action="login" class="login-form">
                <h2>Hotel Login</h2> 

                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-input" placeholder="Enter your email" required>
                </div>
                
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-input" placeholder="Enter your password">
                </div>
                
                <div class="form-group">
                    <button type="submit" class="form-btn">Login</button>
                </div>

                <div class="form-footer">
                    <a href="register.jsp" class="form-link">Don't have an account? Register</a>
                </div>
            </form>
        </div>
    </body>
</html>
