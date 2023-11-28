
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registration Form</title>
        <link rel="stylesheet" href="Styles/registration.css">
    </head>
    
    <body>
        <div class="main-container">
             
            <div class="registration-form">
                <form method="post" action="register">

                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" placeholder="Full Name"required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Example@gmail.com" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" placeholder="*******" required>
                    </div>

                    <div class="form-group">
                        <label for="repeat-password">Repeat Password</label>
                        <input type="password" id="repeat-password" name="repeat-password" placeholder="*******" required>
                    </div>

                    <div class="form-group">
                        <label for="contact">Contact Number</label>
                        <input type="tel" id="contact" name="contact" placeholder="000-000-0000" required>
                    </div>

                    <div class="form-group">
                        <button type="submit">Register</button>
                    </div>

                </form>
            </div>

            <div class="right-container">
                <img src="Images/HotelImage.webp" alt="alt"/>
            </div>
        </div>
        
    </body>
    
</html>

