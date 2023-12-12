package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class FamilyRoom extends Room {
    
    public FamilyRoom(){
        super(GenerateRoomNumber.generate(RoomType.FAMILY_ROOM),RoomType.FAMILY_ROOM);
    }

}
