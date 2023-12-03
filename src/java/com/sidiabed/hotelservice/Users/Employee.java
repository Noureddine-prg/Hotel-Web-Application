package com.sidiabed.hotelservice.Users;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Enums.HotelJob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class Employee extends User {

    private String employeeID;
    private HotelJob jobTitle;
    private boolean isAdmin;

    public Employee(String employeeID, HotelJob jobTitle, boolean isAdmin, String fullName, String email, String passwordHash, String phoneNumber) {
        super(fullName, email, passwordHash, phoneNumber);
        this.employeeID = employeeID;
        this.jobTitle = jobTitle;
        this.isAdmin = isAdmin;
    }
   
    @Override
    public void toSql() {
        String sql = "INSERT INTO employees (employeeID, jobTitle, fullName, email, passwordHash, phoneNumber, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = DBSupport.establishConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, this.employeeID);
            pst.setString(2, this.jobTitle.toString());
            pst.setString(3, this.getFullName());
            pst.setString(4, this.getEmail());
            pst.setString(5, this.getPasswordHash());
            pst.setString(6, this.getPhoneNumber());
            pst.setBoolean(7, this.isAdmin);
            
        }   catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error inserting employee: " + e.getMessage());
        }
        
    }
    
}