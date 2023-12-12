package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Enums.HotelJob;
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


@WebServlet("/employee-create")
public class CreateEmployeeServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        HotelJob jobTitle = HotelJob.valueOf(request.getParameter("jobTitle"));
        UserFactory factory = new UserFactory();
        Employee newEmployee = null;
        
        System.out.println(fullName);
        System.out.println(email);
        System.out.println(password);
        System.out.println(phoneNumber);
        
        if(jobTitle == HotelJob.CONCIERGE){
            System.out.println("Job title is conc");
        }
        
        System.out.println(request.getParameter("jobTitle"));
        
        try {
            newEmployee = factory.createEmployee(jobTitle, false, fullName, email, PasswordHash.hashPassword(password),phoneNumber);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        newEmployee.toSql();
        
        response.sendRedirect("adminpanel.jsp");
    
    }
}