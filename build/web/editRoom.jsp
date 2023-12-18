<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Room</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./Styles/create.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Edit Room</h1>
            
            <form action="room-update" method="post">
                <input type="text" name="roomNumber" value="${room.roomNumber}" readonly><br>
                <input type="text" name="roomType" value="${room.roomType}" readonly><br>
                <input type="text" name="bedType" value="${room.bedType}" readonly><br>
                <input type="text" name="bedCount" value="${room.bedCount}" readonly><br>
                <select name="availability">
                    <option value="AVAILABLE" ${room.availability == 'AVAILABLE' ? 'selected' : ''}>Available</option>
                    <option value="UNAVAILABLE" ${room.availability == 'UNAVAILABLE' ? 'selected' : ''}>Unavailable</option>
                </select><br>
                
                <button type="submit">Update Room</button>
            </form>
        </div>
    </body>
</html>
