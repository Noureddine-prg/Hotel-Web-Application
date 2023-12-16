package com.sidiabed.hotelservice.Servlet;

import com.sidiabed.hotelservice.Enum.HotelJob;
import com.sidiabed.hotelservice.Dao.EmployeeDAO;
import com.sidiabed.hotelservice.Factories.UserFactory;
import com.sidiabed.hotelservice.Users.Employee;
import com.sidiabed.hotelservice.Utility.PasswordHash;
import jakarta.servlet.RequestDispatcher;
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


@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        
        
        String fullNameCreate = request.getParameter("fullName");
        String emailCreate = request.getParameter("email");
        String passwordCreate = request.getParameter("password");
        String phoneNumberCreate = request.getParameter("phoneNumber");           
        String jobTitleCreate = request.getParameter("jobTitle");
             
        // Create a new employee
        UserFactory factoryCreate = new UserFactory();
        Employee newEmployee = null;

        try {
            newEmployee = factoryCreate.createEmployee(HotelJob.valueOf(jobTitleCreate), fullNameCreate, emailCreate, PasswordHash.hashPassword(passwordCreate), phoneNumberCreate);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Save the new employee to the database
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.dbEmployee(newEmployee);
                    
        request.getSession().setAttribute("employee", employeeDAO.getAllEmployees());
                    
        // Redirect to the admin panel or confirmation page
        response.sendRedirect("adminpanel.jsp");            
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String employeeId = request.getParameter("employeeId");
        
        EmployeeDAO employeeDAO = new EmployeeDAO();
        
        try {
            employeeDAO.deleteEmployee(employeeId);
             response.sendRedirect("adminpanel.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        System.out.println("Get method");
        String path = request.getServletPath();
        
        System.out.println(path);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        
        //Add all employees from db into list
        List<Employee> employees = employeeDAO.getAllEmployees();
       
        //allowing jsp page to interact with data
        request.getSession().setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminpanel.jsp");
        dispatcher.forward(request, response);
    }
}

