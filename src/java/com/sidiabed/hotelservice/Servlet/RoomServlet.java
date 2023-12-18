package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Dao.RoomDAO;
import com.sidiabed.hotelservice.Rooms.*;
import com.sidiabed.hotelservice.Factories.HotelRoomFactory;
import com.sidiabed.hotelservice.Enum.RoomType;
import com.sidiabed.hotelservice.Enum.Availability;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/room", "/room-create", "/room-delete", "/room-get", "/room-update"})
public class RoomServlet extends HttpServlet {

    private RoomDAO roomDAO = new RoomDAO();
    private HotelRoomFactory roomFactory = new HotelRoomFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case "/room-create":
                    String roomTypeStr = request.getParameter("roomType");
                    RoomType roomType = RoomType.valueOf(roomTypeStr);
                    Room newRoom = createRoomWithType(roomType);
                    roomDAO.addRoom(newRoom);
                    break;
                case "/room-update":
                    String roomNumberUpdate = request.getParameter("roomNumber");
                    Room roomToUpdate = roomDAO.getRoom(roomNumberUpdate);
                   
                    if (roomToUpdate != null) {
                        String availabilityStr = request.getParameter("availability");
                        if (availabilityStr != null && !availabilityStr.isEmpty()) {
                            roomToUpdate.setAvailability(Availability.valueOf(availabilityStr));
                            roomDAO.updateRoom(roomToUpdate);
                        }
                    }
                    break;
                case "/room-delete":
                    String roomNumberDelete = request.getParameter("roomNumber");
                    roomDAO.deleteRoom(roomNumberDelete);
                    break;
                default:
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.sendRedirect("adminpanel.jsp");
    }

    private Room createRoomWithType(RoomType roomType) {
        switch (roomType) {
            case DELUXE:
                return roomFactory.createDeluxeRoom();
            case EXECUTIVE_SUITE:
                return roomFactory.createExecutiveSuite();
            case FAMILY_ROOM:
                return roomFactory.createFamilyRoom();
            case PRESIDENTIAL_SUITE:
                return roomFactory.createPresidentialSuite();
            case STANDARD:
                return roomFactory.createStandardRoom();
            default:
                return null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        try {
            switch (path) {
                case "/room":
                    System.out.println("getting all rooms");
                    List<Room> rooms = roomDAO.getAllRooms();
                    request.getSession().setAttribute("rooms", rooms);
                    response.sendRedirect("adminpanel.jsp");     

                    break;

                case "/room-get":
                    String roomNumberGet = request.getParameter("roomNumber");
                    Room roomToGet = roomDAO.getRoom(roomNumberGet);
                    request.setAttribute("room", roomToGet);
                    request.getRequestDispatcher("/editRoom.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
