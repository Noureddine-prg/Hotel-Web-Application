package com.sidiabed.hotelservice.Factories;

import com.sidiabed.hotelservice.Enum.RoomType;
import static com.sidiabed.hotelservice.Enum.RoomType.DELUXE;
import static com.sidiabed.hotelservice.Enum.RoomType.EXECUTIVE_SUITE;
import static com.sidiabed.hotelservice.Enum.RoomType.FAMILY_ROOM;
import static com.sidiabed.hotelservice.Enum.RoomType.PRESIDENTIAL_SUITE;
import static com.sidiabed.hotelservice.Enum.RoomType.STANDARD;
import com.sidiabed.hotelservice.Rooms.*;

public class HotelRoomFactory {
    
    public DeluxeRoom createDeluxeRoom(){
        DeluxeRoom deluxeRoom = new DeluxeRoom();
      
        return deluxeRoom;
    }
    
    public ExecutiveSuite createExecutiveSuite(){
        
        ExecutiveSuite executiveRoom = new ExecutiveSuite();
      
        return executiveRoom;
    }
    
    public FamilyRoom createFamilyRoom(){
        
        FamilyRoom familyRoom = new FamilyRoom();

        return familyRoom;
    }
    
    public PresidentialSuite createPresidentialSuite(){
        
        PresidentialSuite presidentRoom = new PresidentialSuite();
                
        return presidentRoom;
    }
    
    public StandardRoom createStandardRoom(){
        
        StandardRoom standardRoom = new StandardRoom();
        
        return standardRoom;
    }
   
    

}
