package com.sidiabed.hotelservice.Factories;

import com.sidiabed.hotelservice.Rooms.*;

public class HotelRoomFactory {
    
    public DeluxeRoom createDeluxeRoom(){
        
        // Make new Room. 
        DeluxeRoom deluxeRoom = new DeluxeRoom();
        
        //Store to DB
        try {
            deluxeRoom.toSql();
        } catch (Exception e) {
            System.out.println("Can't create room");
            return null;
        }
        
        return deluxeRoom;
    }
    
    public ExecutiveSuite createExecutiveSuite(){
        
        ExecutiveSuite executiveRoom = new ExecutiveSuite();
        
        try{
            executiveRoom.toSql();
        }catch(Exception e){
            System.out.println("Can't create room");
            return null;
        }
        
        return executiveRoom;
    }
    
    public FamilyRoom createFamilyRoom(){
        
        FamilyRoom familyRoom = new FamilyRoom();
        
        try {
            familyRoom.toSql();
        } catch (Exception e) {
            System.out.println("Can't create room"); 
            return null;            
        }
        
        return familyRoom;
    }
    
    public PresidentialSuite createPresidentialSuite(){
        
        PresidentialSuite presidentRoom = new PresidentialSuite();
        
        try {
            presidentRoom.toSql();
        } catch (Exception e) {
            System.out.println("Can't create room");
            return null;            
        }
        
        
        return presidentRoom;
    }
    
    public StandardRoom createStandardRoom(){
        
        StandardRoom standardRoom = new StandardRoom();
        
        try {
            standardRoom.toSql();
        } catch (Exception e) {
            System.out.println("Can't create room");
            return null;
        }
        
        return standardRoom;
    }
   
}
