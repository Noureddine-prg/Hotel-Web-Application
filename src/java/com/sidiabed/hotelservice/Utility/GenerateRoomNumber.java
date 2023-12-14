package com.sidiabed.hotelservice.Utility;

import com.sidiabed.hotelservice.Enum.RoomType;

public class GenerateRoomNumber {

    private static int lastRoomNumber = 100; 

    public static String generate(RoomType roomType) {
        String prefix = getPrefixForRoomType(roomType);
        lastRoomNumber++; 
        return prefix + "-" + lastRoomNumber;
    }

    private static String getPrefixForRoomType(RoomType roomType) {
        switch (roomType) {
            case STANDARD:
                return "S";
            case DELUXE:
                return "D";
            case EXECUTIVE_SUITE:
                return "E";
            case PRESIDENTIAL_SUITE:
                return "P";
            case FAMILY_ROOM:
                return "F";
            case HONEYMOON_SUITE:
                return "H";
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }

    public static int getLastRoomNumber() {
        return lastRoomNumber;
    }
}
