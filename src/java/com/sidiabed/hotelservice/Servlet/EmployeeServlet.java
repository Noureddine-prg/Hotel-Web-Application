package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Enum.HotelJob;
import com.sidiabed.hotelservice.Dao.EmployeeDAO;
import com.sidiabed.hotelservice.Factories.UserFactory;
import com.sidiabed.hotelservice.Users.Employee;
import com.sidiabed.hotelservice.Utility.PasswordHash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;




@WebServlet(urlPatterns = {"/employee-create", "/employee-read", "/employee-update", "/employee-delete"})
public class EmployeeServlet extends HttpServlet{
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        
        
        String path = request.getServletPath();
        
        switch(path){
            
                case "/employee-create":
                    String fullNameCreate = request.getParameter("fullName");
                    String emailCreate = request.getParameter("email");
                    String passwordCreate = request.getParameter("password");
                    String phoneNumberCreate = request.getParameter("phoneNumber");           
                    
                    
                    //currently this will give me an error but if I make it a string it will add all the data to the employee form properly
                    HotelJob jobTitleCreate = HotelJob.valueOf(request.getParameter("jobTitle"));
              
                    System.out.println(jobTitleCreate);
                    // Create a new employee
                    UserFactory factoryCreate = new UserFactory();
                    Employee newEmployee = null;

                    try {
                        newEmployee = factoryCreate.createEmployee(jobTitleCreate, fullNameCreate, emailCreate, PasswordHash.hashPassword(passwordCreate), phoneNumberCreate);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Save the new employee to the database
                    EmployeeDAO employeeDao = new EmployeeDAO();
                    employeeDao.dbEmployee(newEmployee);
                    

                    // Redirect to the admin panel or confirmation page
                    response.sendRedirect("adminpanel.jsp");


                    break;
                
                case "/employee-update":
                    
                    break;
                    
                case "/employee-delete":
                    
                    break;
        
        }
    }
}

