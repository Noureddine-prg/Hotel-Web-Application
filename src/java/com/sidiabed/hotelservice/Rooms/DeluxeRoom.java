package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enum.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class DeluxeRoom extends Room{
    public DeluxeRoom(){
        super(GenerateRoomNumber.generate(RoomType.DELUXE),RoomType.DELUXE);
        
    }
    public DeluxeRoom(String roomNumber){
        super(roomNumber,RoomType.DELUXE);
        
    }
    
}
