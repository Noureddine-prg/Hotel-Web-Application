
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
    <body>
        <div>
        <form method="post" action="login">
            
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Example@gmail.com" required>
            </div>
           
            <div class="form-group">
                <label>Password</label>
                <input type="password" id="password" name="password" placeholder="*******">
            </div>
            
            <div class="form-group">
                <button type="submit">Login</button>
            </div>
        </form>
        
        </div>
    </body>
</html>
