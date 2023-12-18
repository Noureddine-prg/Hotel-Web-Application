package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enum.Availability;
import com.sidiabed.hotelservice.Enum.RoomType;
import com.sidiabed.hotelservice.Interfaces.BookRoom;


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
