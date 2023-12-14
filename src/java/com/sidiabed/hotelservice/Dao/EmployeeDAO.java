
package com.sidiabed.hotelservice.Dao;

import com.sidiabed.hotelservice.DBSupport.DBSupport;
import com.sidiabed.hotelservice.Users.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author noureddine
 * 
 * Employee CRUD operations
 */
public class EmployeeDAO {
        
    public void dbEmployee(Employee employee) {
        String sql = "INSERT INTO employees (employeeID, jobTitle, fullName, email, passwordHash, phoneNumber, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = DBSupport.establishConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
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
    
    public Employee getEmployee(String employeeID){
    
        return null;
    }
    
    public List<Employee> getAllEmployees(){
    
        return null;
    }
    
    public void updateEmployee(Employee employee){
    
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
