package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enums.Availability;
import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class ExecutiveSuite extends Room {
    
    public ExecutiveSuite(){
        super(GenerateRoomNumber.generate(RoomType.EXECUTIVE_SUITE),RoomType.EXECUTIVE_SUITE);
    }

}


