package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Users.Guest;
import com.sidiabed.hotelservice.Utility.PasswordHash;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        RequestDispatcher dispatcher = null;
        Connection conn = null;
         
        try {
            Guest newGuest = new Guest(name, email, PasswordHash.hashPassword(password), contact, null);
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelDB","root","password");
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO guests (guestID, fullName, email, passwordHash, phoneNumber) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, newGuest.getGuestID());
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, newGuest.getPasswordHash());
            pst.setString(5, contact);
            
            int rowCount = pst.executeUpdate();
                        
            if(rowCount > 0){
                request.setAttribute("status", "success");
                response.sendRedirect("login.jsp"); 
            } else {
                request.setAttribute("status", "failure");
                dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }
               
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Handles user registrations";
    }
    
}
