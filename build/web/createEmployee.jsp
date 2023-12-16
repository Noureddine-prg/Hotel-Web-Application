<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Employee</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="employee" method="post">
            <input type="text" name="fullName" placeholder="Full Name" required />
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />
            <input type="text" name="phoneNumber" placeholder="Phone Number" required />
            <select name="jobTitle" id="jobTitle">
                <option value="CONCIERGE">CONCIERGE</option>
                <option value="RECEPTIONIST">RECEPTIONIST</option>
                <option value="HOUSEKEEPER">HOUSEKEEPER</option>
                <option value="CHEF">CHEF</option>
                <option value="KITCHEN_STAFF">KITCHEN_STAFF</option>
                <option value="WAITER_WAITRESS">WAITER/WAITRESS</option>
                <option value="SECURITY_GUARD">SECURITY_GUARD</option>
                <option value="VALET">VALET</option>                                           
            </select>
            <input type="submit" value="submit" />
        </form>

    </body>
   
</html>
