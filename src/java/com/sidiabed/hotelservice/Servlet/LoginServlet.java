package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Utility.PasswordHash;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("In login servlet");
        
        RequestDispatcher dispatcher = null;
        Connection conn = null;
        String email = request.getParameter("email");
        String passwordHash = request.getParameter("password");
        HttpSession session = request.getSession();
 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelDB","root","password");
            
            //Selecting emails & passwords from user and employee tables.
            PreparedStatement pst = conn.prepareStatement(    
                "SELECT email, fullName, passwordHash FROM users WHERE email = ? AND passwordHash = ? " +
                "UNION " +
                "SELECT email, fullName, passwordHash FROM employees WHERE email = ? AND passwordHash = ?"
            );
          
            pst.setString(1,email);
            pst.setString(2, PasswordHash.hashPassword(passwordHash));
            pst.setString(3, email);
            pst.setString(4, PasswordHash.hashPassword(passwordHash));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                //session obj value being set
                session.setAttribute("name", rs.getString("fullName"));
                dispatcher = request.getRequestDispatcher("index.jsp");
                //dispatcher.forward(request, response);
                response.sendRedirect("index.jsp"); 
           
            }else{
                request.setAttribute("status","failed");
                dispatcher = request.getRequestDispatcher("registration.jsp");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        } 
     
    }
    
}
