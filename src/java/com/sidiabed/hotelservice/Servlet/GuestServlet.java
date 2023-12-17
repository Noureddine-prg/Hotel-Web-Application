package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Dao.GuestDAO;
import com.sidiabed.hotelservice.Users.Guest;
import com.sidiabed.hotelservice.Utility.PasswordHash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/guest", "/guest-create", "/guest-delete", "/guest-get", "/guest-edit"})
public class GuestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        GuestDAO guestDAO = new GuestDAO();

        switch (path) {
            case "/guest-create":
                String fullNameCreate = request.getParameter("fullName");
                String emailCreate = request.getParameter("email");
                String passwordCreate = request.getParameter("password");
                String phoneNumberCreate = request.getParameter("phoneNumber");
                String roomBookedCreate = request.getParameter("roomBooked");

                try {
                    Guest newGuest = new Guest(fullNameCreate, emailCreate, PasswordHash.hashPassword(passwordCreate), phoneNumberCreate, roomBookedCreate);
                    guestDAO.dbGuest(newGuest);
                    response.sendRedirect("adminpanel.jsp");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(GuestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating guest");
                }
                break;

            case "/guest-delete":
                String guestIdDelete = request.getParameter("guestId");
                try {
                    guestDAO.deleteGuest(guestIdDelete);
                    response.sendRedirect("adminpanel.jsp");
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting guest");
                }
                break;

            case "/guest-edit":
                String guestIdEdit = request.getParameter("guestId");
                String fullNameEdit = request.getParameter("fullName");
                String emailEdit = request.getParameter("email");
                String passwordEdit = request.getParameter("password");
                String phoneNumberEdit = request.getParameter("phoneNumber");
                String roomBookedEdit = request.getParameter("roomBooked");

                try {
                    Guest guestEdit = new Guest(guestIdEdit, fullNameEdit, emailEdit, PasswordHash.hashPassword(passwordEdit), phoneNumberEdit, roomBookedEdit);
                    guestDAO.updateGuest(guestEdit);
                    response.sendRedirect("adminpanel.jsp");
                } catch (NoSuchAlgorithmException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating guest");
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String path = request.getServletPath();
        GuestDAO guestDAO = new GuestDAO();

        switch (path) {
            case "/guest":
                List<Guest> guests = guestDAO.getAllGuests();
                request.getSession().setAttribute("guests", guests);

                request.getRequestDispatcher("adminpanel.jsp").forward(request, response);
                break;

            case "/guest-get":
                String guestIdGet = request.getParameter("guestId");
                try {
                    Guest guest = guestDAO.getSpecificGuest(guestIdGet);
                    request.setAttribute("guestToEdit", guest);
                    request.getRequestDispatcher("editGuest.jsp").forward(request, response);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching specific guest");
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
                break;
        }
    }
}
