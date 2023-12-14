package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enum.Availability;
import com.sidiabed.hotelservice.Enum.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class ExecutiveSuite extends Room {
    
    public ExecutiveSuite(){
        super(GenerateRoomNumber.generate(RoomType.EXECUTIVE_SUITE),RoomType.EXECUTIVE_SUITE);
    }

}


