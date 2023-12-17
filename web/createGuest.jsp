<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Guest</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./Styles/create.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Create New Guest</h1>
            
            <form action="guest-create" method="post">
                <input type="text" name="fullName" placeholder="Full Name" required />
                <input type="email" name="email" placeholder="Email" required />
                <input type="password" name="password" placeholder="Password" required />
                <input type="text" name="phoneNumber" placeholder="Phone Number" required />
                <input type="text" name="roomBooked" placeholder="Room Booked" />
                <input type="submit" value="submit" />
            </form>
        </div>
    </body>
</html>
