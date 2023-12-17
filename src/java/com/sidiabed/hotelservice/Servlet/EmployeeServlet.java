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

@WebServlet(urlPatterns = {"/employee", "/employee-create", "/employee-delete", "/employee-get", "/employee-edit"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        switch (path) {
            case "/employee-create":
                String fullNameCreate = request.getParameter("fullName");
                String emailCreate = request.getParameter("email");
                String passwordCreate = request.getParameter("password");
                String phoneNumberCreate = request.getParameter("phoneNumber");
                String jobTitleCreate = request.getParameter("jobTitle");

                UserFactory factoryCreate = new UserFactory();
                Employee newEmployee = null;

                try {
                    newEmployee = factoryCreate.createEmployee(HotelJob.valueOf(jobTitleCreate), fullNameCreate, emailCreate, PasswordHash.hashPassword(passwordCreate), phoneNumberCreate);
                    employeeDAO.dbEmployee(newEmployee);
                    response.sendRedirect("adminpanel.jsp");
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error employee creation");
                }
                break;

            case "/employee-delete":
                String employeeId = request.getParameter("employeeId");
                try {
                    employeeDAO.deleteEmployee(employeeId);
                    response.sendRedirect("adminpanel.jsp");
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error employee deletion");
                }
                break;
            case "/employee-edit":
                    String eId = request.getParameter("employeeId");
                    String fullName = request.getParameter("fullName");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String jobTitle = request.getParameter("jobTitle");
                    boolean isAdmin = request.getParameter("isAdmin") != null;
                    
                    Employee currentEmployee = null;
            
                    try {
                        currentEmployee = new Employee(eId, HotelJob.valueOf(jobTitle), fullName, email, PasswordHash.hashPassword(password), phoneNumber, isAdmin);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    {
                        try {
                            employeeDAO.updateEmployee(currentEmployee);
                            response.sendRedirect("adminpanel.jsp");
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                break;

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        EmployeeDAO employeeDAO = new EmployeeDAO();

                        
        switch (path){
            case "/employee":
                List<Employee> employees = employeeDAO.getAllEmployees();
                request.getSession().setAttribute("employees", employees);
                response.sendRedirect("adminpanel.jsp");               
                
                break;
            case "/employee-get":
                System.out.println("We are now grabbing employee");

                String employeeId = request.getParameter("employeeId");
                
                try {
                    Employee employee = employeeDAO.getSpecificEmployee(employeeId);
                    request.setAttribute("employeeToEdit", employee);
                    response.sendRedirect("editEmployee.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            

                
                break;

            }
        

    }

}


