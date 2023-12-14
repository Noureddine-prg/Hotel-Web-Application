package com.sidiabed.hotelservice.Users;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Utility.GenerateUserID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Guest extends User {
    
    private String guestID;

    public Guest(String fullName, String email, String passwordHash, String phoneNumber) {
        super(fullName, email, passwordHash, phoneNumber);
        this.guestID = GenerateUserID.generateGuestID();
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

 
    public void toSql() {
        String sql = "INSERT INTO guests (guestID, fullName, email, passwordHash, phoneNumber) VALUES (?, ?, ?, ?, ?)";
        
        try{
            Connection conn = DBSupport.establishConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, this.getGuestID());
            pst.setString(2, this.getFullName());
            pst.setString(3, this.getEmail());
            pst.setString(4, this.getPasswordHash());
            pst.setString(5, this.getPhoneNumber());
            
            pst.executeUpdate();
            
        }   catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error creating guest: " + e.getMessage());
        }
    }
    
}
