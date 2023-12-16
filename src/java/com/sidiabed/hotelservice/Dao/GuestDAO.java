package com.sidiabed.hotelservice.Dao;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Users.Guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    public void dbGuest(Guest guest) {
        String query = "INSERT INTO guests (guestID, fullName, email, passwordHash, phoneNumber) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, guest.getGuestID());
            pst.setString(2, guest.getFullName());
            pst.setString(3, guest.getEmail());
            pst.setString(4, guest.getPasswordHash());
            pst.setString(5, guest.getPhoneNumber());
            
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error creating guest: " + e.getMessage());
        }       
    }
    
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        String query = "SELECT * FROM guests";     
        
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                String guestID = rs.getString("guestID");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String passwordHash = rs.getString("passwordHash");
                String phoneNumber = rs.getString("phoneNumber");
                
                Guest guest = new Guest(fullName, email, passwordHash, phoneNumber);
                guest.setGuestID(guestID);
                
                guests.add(guest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching guests: " + e.getMessage());
        }
        return guests;
    }
    
    public Guest getSpecificGuest(String guestID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM guests WHERE guestID = ?";
        Guest guest = null;

        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, guestID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String passwordHash = rs.getString("passwordHash");
                String phoneNumber = rs.getString("phoneNumber");

                guest = new Guest(fullName, email, passwordHash, phoneNumber);
                guest.setGuestID(guestID);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching specific guest: " + e.getMessage());
            throw e;
        }
        return guest;
    }
    
    public void updateGuest(Guest guest) throws SQLException, ClassNotFoundException {
        String query = "UPDATE guests SET fullName = ?, email = ?, passwordHash = ?, phoneNumber = ? WHERE guestID = ?";

        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getEmail());
            pstmt.setString(3, guest.getPasswordHash());
            pstmt.setString(4, guest.getPhoneNumber());
            pstmt.setString(5, guest.getGuestID());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error updating guest: " + e.getMessage());
            throw e;
        }
    }
    
    public void deleteGuest(String guestID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM guests WHERE guestID = ?";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guestID);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error deleting guest: " + e.getMessage());
            throw e;
        }    
    }
}
