<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create New Room</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./Styles/create.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Create New Room</h1>
            
            <form action="room-create" method="post">
                
                <select name="roomType" id="roomType">
                    <option value="STANDARD">Standard</option>
                    <option value="DELUXE">Deluxe</option>
                    <option value="EXECUTIVE_SUITE">Executive Suite</option>
                    <option value="PRESIDENTIAL_SUITE">Presidential Suite</option>
                    <option value="FAMILY_ROOM">Family Room</option>
                </select>

                <input type="submit" value="submit" />
            </form>
        </div>
    </body>
</html>
