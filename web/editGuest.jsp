<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Guest</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./Styles/create.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Edit Guest</h1>
            
            <form action="guest-edit" method="post">
                Guest ID: <input type="text" name="guestId" value="${guestToEdit.guestID}" readonly><br>
                <input type="text" name="fullName" value="${guestToEdit.fullName}" required><br>
                <input type="email" name="email" value="${guestToEdit.email}" required><br>
                <input type="password" name="password" value="${guestToEdit.passwordHash}">
                <input type="tel" name="phoneNumber" value="${guestToEdit.phoneNumber}" required><br>
                <input type="text" name="roomBooked" value="${guestToEdit.roomBooked}"><br>
                
                <button type="submit">Update Guest</button>
            </form>
        </div>
    </body>
</html>
