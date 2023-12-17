package com.sidiabed.hotelservice.Users;

import com.sidiabed.hotelservice.Utility.GenerateUserID;

public class Guest extends User {
    
    private String guestID;
    private String roomBooked;

    
    public Guest(String guestID, String fullName, String email, String passwordHash, String phoneNumber, String roomBooked) {
        super(fullName, email, passwordHash, phoneNumber);
        this.guestID = guestID; 
        this.roomBooked = roomBooked; 
    }

    public Guest(String fullName, String email, String passwordHash, String phoneNumber, String roomBooked) {
        super(fullName, email, passwordHash, phoneNumber);
        this.guestID = GenerateUserID.generateGuestID();
        this.roomBooked = roomBooked; 
    }
    
    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getRoomBooked() {
        return roomBooked;
    }

    public void setRoomBooked(String roomBooked) {
        this.roomBooked = roomBooked;
    }
 
    
    
}
