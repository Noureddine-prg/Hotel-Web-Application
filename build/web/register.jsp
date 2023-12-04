<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" href="Styles/register.css"/>
    
    <script>
        function redirectToLogin() {
            window.location.href = 'login.jsp';
        }
    </script>

</head>
<body>

<div class="split_left left">
    <div class="left-centered">
        <h2>Have an account already?</h2>
        <button onclick="redirectToLogin()" class="btn">Sign In</button>
    </div>
</div>

<div class="split_right right">
        <form class="register-form" action="register" method="post">
            <h2>Create Account</h2>
            
            <div class="form-field_container">
                <label>Full Name</label>
                <input type="text" id="name" name="name" placeholder="Full Name" required>
            </div>
            
            <div class="form-field_container">
                <label>Email</label>
                <input type="email" id="email" name="email" placeholder="Email" required>                
            </div>

            <div class="form-field_container">
                <label>Password</label>
                <input type="password" id="password" name="password" placeholder="**********" required>                
            </div>

            <div class="form-field_container">
                <label>Phone Number</label>
                <input type="tel" id="contact" name="contact" placeholder="000-000-0000" required>                
            </div>            
            
            <div class="button-container">
                <button class="btn" type="submit">Sign up</button>
            </div>
        </form>
</div>

</body>
</html>

