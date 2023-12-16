
package com.sidiabed.hotelservice.Dao;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Enum.HotelJob;
import com.sidiabed.hotelservice.Users.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noureddine
 * 
 * Employee CRUD and DB operations 
 */
public class EmployeeDAO {
        
    public void dbEmployee(Employee employee) {
        String query = "INSERT INTO employees (employeeID, jobTitle, fullName, email, passwordHash, phoneNumber, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = DBSupport.establishConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, employee.getEmployeeID());
            pst.setString(2, employee.getJobTitle().toString());
            pst.setString(3, employee.getFullName());
            pst.setString(4, employee.getEmail());
            pst.setString(5, employee.getPasswordHash());
            pst.setString(6, employee.getPhoneNumber());
            pst.setBoolean(7, employee.isIsAdmin());
            
             pst.executeUpdate();
            
        }   catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }       
    }
    
    public List<Employee> getAllEmployees(){
        
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";     
        
        try {
            Connection conn = DBSupport.establishConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                String employeeID = rs.getString("employeeID");
                HotelJob jobTitle = HotelJob.valueOf(rs.getString("jobTitle"));
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String passwordHash = rs.getString("passwordHash");
                String phoneNumber = rs.getString("phoneNumber");
                boolean isAdmin = rs.getBoolean("isAdmin");
                
                Employee employee = new Employee(employeeID, jobTitle, fullName, email, passwordHash, phoneNumber, isAdmin);
                
                employees.add(employee);
            }
                    
        } catch (Exception e) {
        }
        
                System.out.println(employees);        
        return employees;
    }
    
    public Employee getSpecificEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM employees WHERE employeeID = ?";
        Employee employee = null;

        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String passwordHash = rs.getString("passwordHash");
                String phoneNumber = rs.getString("phoneNumber");
                HotelJob jobTitle = HotelJob.valueOf(rs.getString("jobTitle"));
                boolean isAdmin = rs.getBoolean("isAdmin");

                employee = new Employee(employeeId, jobTitle, fullName, email, passwordHash, phoneNumber, isAdmin);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error fetching specific employee: " + e.getMessage());
            throw e;
        }
        return employee;
    }
    
    public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String query = "UPDATE employees SET jobTitle = ?, fullName = ?, email = ?, passwordHash = ?, phoneNumber = ?, isAdmin = ? WHERE employeeID = ?";

        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, employee.getJobTitle().toString());
            pstmt.setString(2, employee.getFullName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPasswordHash());
            pstmt.setString(5, employee.getPhoneNumber());
            pstmt.setBoolean(6, employee.isIsAdmin());
            pstmt.setString(7, employee.getEmployeeID());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error updating employee: " + e.getMessage());
            // It's usually a good practice to rethrow the exception or handle it appropriately
            throw e;
        }
    }
    

    
    public void deleteEmployee(String employeeID) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM employees WHERE employeeID = ?";
        try (Connection conn = DBSupport.establishConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employeeID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }    
    }
    
    
}
