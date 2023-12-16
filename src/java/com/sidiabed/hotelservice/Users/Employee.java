package com.sidiabed.hotelservice.Users;

import com.sidiabed.hotelservice.Enum.HotelJob;
import com.sidiabed.hotelservice.Servlet.EmployeeServlet;
import com.sidiabed.hotelservice.Utility.GenerateUserID;




public class Employee extends User {

    private String employeeID;
    private HotelJob jobTitle;
    private boolean isAdmin;

    public Employee(HotelJob jobTitle, String fullName, String email, String passwordHash, String phoneNumber) {
        super(fullName, email, passwordHash, phoneNumber);
        this.employeeID = GenerateUserID.generateEmployeeID();
        this.jobTitle = jobTitle;
        this.isAdmin = false;
    }
    
    public Employee(String employeeID, HotelJob jobTitle, String fullName, String email, String passwordHash, String phoneNumber, boolean isAdmin) {
        super(fullName, email, passwordHash, phoneNumber);
        this.employeeID = employeeID;
        this.jobTitle = jobTitle;
        this.isAdmin = isAdmin;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public HotelJob getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(HotelJob jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
        @Override
        public String toString() {
        return "Employee{" +
                "employeeID='" + this.employeeID + '\'' +
                ", jobTitle=" + this.jobTitle +
                ", fullName='" + this.getFullName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", isAdmin=" + this.isIsAdmin() +
                '}';
    }
        
}