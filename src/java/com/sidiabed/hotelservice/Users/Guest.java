package com.sidiabed.hotelservice.Users;

public class Guest extends User {
    
    private String guestID;

    public Guest(String fullName, String email, String passwordHash, String phoneNumber) {
        super(fullName, email, passwordHash, phoneNumber);
        this.guestID = guestID;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    @Override
    public void toSql() {
    }
    
}
