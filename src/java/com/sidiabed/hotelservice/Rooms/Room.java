package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Enums.Availability;
import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Interfaces.BookRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public abstract class Room implements BookRoom{
    
    private String roomNumber;
    private RoomType roomType;
    private String currentGuestID;
    private String currentCleaner;
    private Availability availability;
    

    public Room(String roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.currentGuestID = null;
        this.currentCleaner = null;
        this.availability = Availability.AVAILABLE;
        
    }
         
    public void toSql() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO rooms (roomNumber, roomType, bedType, bedCount, assignedCleaner, availability, currentGuestID, guestCheckedIn) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pst = null;
    
        try {
            conn = DBSupport.establishConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, this.getRoomNumber());
            pst.setString(2, this.getRoomType().toString());
            pst.setString(3, this.getBedType()); 
            pst.setInt(4, this.getBedCount());
            pst.setString(5, this.getCurrentCleaner());
            pst.setString(6, this.getAvailability().toString());
            pst.setString(7, this.getCurrentGuestID());
            pst.setInt(8, 0); 

            pst.executeUpdate();
        } finally {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        }
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getRoomNumber(){
        return roomNumber;
    }
    
    public int getBedCount(){
        return roomType.getBedCount();
    }
    
    public int getPricePerNight(){
        return roomType.getPricePerNight();
    }
    
    public String getDescription(){
        return roomType.getDescription();
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getBedType(){
        return roomType.getBedType();
    }
    
    public String getCurrentGuestID() {
        return currentGuestID;
    }

    public void setCurrentGuest(String currentGuestID) {
        this.currentGuestID = currentGuestID;
    }

    public String getCurrentCleaner() {
        return currentCleaner;
    }

    public void setCurrentCleaner(String currentCleaner) {
        this.currentCleaner = currentCleaner;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    
    
}
