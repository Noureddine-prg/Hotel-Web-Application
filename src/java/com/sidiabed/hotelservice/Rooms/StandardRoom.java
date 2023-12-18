package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enum.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class StandardRoom extends Room {
    
    public StandardRoom(){
        super(GenerateRoomNumber.generate(RoomType.STANDARD),RoomType.STANDARD);
    }
    
    public StandardRoom(String roomNumber) {
        super(roomNumber, RoomType.STANDARD);
    }
    
}
