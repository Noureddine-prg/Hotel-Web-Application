package com.sidiabed.hotelservice.Enums;

public enum RoomType {
    STANDARD(100, 1, "A cozy room with a single bed, ideal for solo travelers.", "TWIN"),
    DELUXE(150, 2, "Spacious room with two beds, perfect for couples or small families.", "FULL"),
    EXECUTIVE_SUITE(200, 1, "Large suite with a king-size bed, a work area, and premium amenities.", "KING"),
    PRESIDENTIAL_SUITE(300, 2, "Luxurious suite with multiple rooms, top-tier amenities, and spectacular views.", "KING"),
    FAMILY_ROOM(180, 4, "Comfortable room for families, with multiple beds and enough space for everyone.", "QUEEN"),
    HONEYMOON_SUITE(250, 1, "Romantic suite with elegant decor, a queen-size bed, and special amenities for couples.", "QUEEN");

    private final int pricePerNight;
    private final int bedCount;
    private final String description;
    private final String bedType;

    
    
    RoomType(int pricePerNight, int bedCount, String description, String bedType) {
        this.pricePerNight = pricePerNight;
        this.bedCount = bedCount;
        this.description = description;
        this.bedType = bedType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public int getBedCount() {
        return bedCount;
    }

    public String getDescription() {
        return description;
    }

    public String getBedType() {
        return bedType;
    }
}





    
