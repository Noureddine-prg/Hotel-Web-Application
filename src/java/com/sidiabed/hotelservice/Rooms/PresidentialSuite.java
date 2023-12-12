package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class PresidentialSuite extends Room {
    
    public PresidentialSuite(){
        super(GenerateRoomNumber.generate(RoomType.PRESIDENTIAL_SUITE),RoomType.PRESIDENTIAL_SUITE);
    }    
    
}
