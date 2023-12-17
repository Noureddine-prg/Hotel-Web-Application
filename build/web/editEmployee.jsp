<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Employee</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./Styles/create.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Edit Employee</h1>
            
                <form action="employee-edit" method="post">
                    Employee ID: <input type="text" name="employeeId" value="${employeeToEdit.employeeID}"readonly>
                    <input type="text" name="fullName" value="${employeeToEdit.fullName}"><br>
                    <input type="email" name="email" value="${employeeToEdit.email}"><br>
                    <input type="password" name="password" value="${employeeToEdit.passwordHash}">
                    <input type="tel" name ="phoneNumber" value="${employeeToEdit.phoneNumber}">
                    
                    <select name="jobTitle" id="jobTitle">
                        <option value="RECEPTIONIST" ${employeeToEdit.jobTitle == 'RECEPTIONIST' ? 'selected' : ''}>RECEPTIONIST</option>
                        <option value="CONCIERGE" ${employeeToEdit.jobTitle == 'CONCIERGE' ? 'selected' : ''}>CONCIERGE</option>
                        <option value="HOUSEKEEPER" ${employeeToEdit.jobTitle == 'HOUSEKEEPER' ? 'selected' : ''}>HOUSEKEEPER</option>
                        <option value="CHEF" ${employeeToEdit.jobTitle == 'CHEF' ? 'selected' : ''}>CHEF</option>
                        <option value="KITCHEN_STAFF" ${employeeToEdit.jobTitle == 'KITCHEN_STAFF' ? 'selected' : ''}>KITCHEN_STAFF</option>
                        <option value="WAITER_WAITRESS" ${employeeToEdit.jobTitle == 'WAITER_WAITRESS' ? 'selected' : ''}>WAITER/WAITRESS</option>
                        <option value="SECURITY_GUARD" ${employeeToEdit.jobTitle == 'SECURITY_GUARD' ? 'selected' : ''}>SECURITY_GUARD</option>
                        <option value="VALET" ${employeeToEdit.jobTitle == 'VALET' ? 'selected' : ''}>VALET</option>
                    </select>
                    
                    <input type="checkbox" name="isAdmin" ${employeeToEdit.isAdmin ? 'checked' : ''}> Admin<br>

                    <button type="submit">Update Employee</button>
                </form>
            

        </div>


    </body>
   
</html>
