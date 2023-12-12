package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class DeluxeRoom extends Room{
    public DeluxeRoom(){
        super(GenerateRoomNumber.generate(RoomType.DELUXE),RoomType.DELUXE);
        
    }

}
