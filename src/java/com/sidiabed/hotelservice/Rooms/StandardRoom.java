package com.sidiabed.hotelservice.Rooms;

import com.sidiabed.hotelservice.Enums.RoomType;
import com.sidiabed.hotelservice.Utility.GenerateRoomNumber;

public class StandardRoom extends Room {
    
    public StandardRoom(){
        super(GenerateRoomNumber.generate(RoomType.STANDARD),RoomType.STANDARD);
    }
    
    @Override
    public void bookRoom(){}
    
}
