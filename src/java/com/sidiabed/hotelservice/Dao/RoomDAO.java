package com.sidiabed.hotelservice.Dao;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Rooms.*;
import com.sidiabed.hotelservice.Enum.RoomType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void addRoom(Room room) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO hotelRooms (roomNumber, roomType, bedType, bedCount, availability) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType().toString());
            pstmt.setString(3, room.getBedType());
            pstmt.setInt(4, room.getBedCount());
            pstmt.setString(5, room.getAvailability().toString());
            pstmt.executeUpdate();
        }
    }

    public List<Room> getAllRooms() throws SQLException, ClassNotFoundException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM hotelRooms";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String roomNumber = rs.getString("roomNumber");
                RoomType roomType = RoomType.valueOf(rs.getString("roomType"));
                Room room = createRoomInstance(roomType, roomNumber);
                System.out.println(room);
                rooms.add(room);
            }
        }
        return rooms;
    }


    private Room createRoomInstance(RoomType roomType, String roomNumber) {
        switch (roomType) {
            case DELUXE:
                return new DeluxeRoom(roomNumber);
            case EXECUTIVE_SUITE:
                return new ExecutiveSuite(roomNumber);
            case FAMILY_ROOM:
                return new FamilyRoom(roomNumber);
            case PRESIDENTIAL_SUITE:
                return new PresidentialSuite(roomNumber);
            case STANDARD:
                return new StandardRoom(roomNumber);
            default:
                return null; 
        }
    }

    public Room getRoom(String roomNumber) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM hotelRooms WHERE roomNumber = ?";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, roomNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                RoomType roomType = RoomType.valueOf(rs.getString("roomType"));
                return createRoomInstance(roomType, roomNumber);
            }
        }
        return null;
    }

    public void updateRoom(Room room) throws SQLException, ClassNotFoundException {
        String query = "UPDATE hotelRooms SET roomType = ?, bedType = ?, bedCount = ?, availability = ? WHERE roomNumber = ?";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, room.getRoomType().toString());
            pstmt.setString(2, room.getBedType());
            pstmt.setInt(3, room.getBedCount());
            pstmt.setString(4, room.getAvailability().toString());
            pstmt.setString(5, room.getRoomNumber());
            pstmt.executeUpdate();
        }
    }

    public void deleteRoom(String roomNumber) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM hotelRooms WHERE roomNumber = ?";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, roomNumber);
            pstmt.executeUpdate();
        }
    }
}
