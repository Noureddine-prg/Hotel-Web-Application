package com.sidiabed.hotelservice.Factories;

import com.sidiabed.hotelservice.Enums.HotelJob;
import com.sidiabed.hotelservice.Users.Employee;
import com.sidiabed.hotelservice.Users.Guest;

public class UserFactory {

    public Employee createEmployee(HotelJob jobTitle, boolean isAdmin, String fullName, String email, String passwordHash, String phoneNumber) {
        Employee em = new Employee(jobTitle, fullName, email, passwordHash, phoneNumber);
        
        em.toSql();
        
        return em;
    }

    public Guest createGuest(String fullName, String email, String passwordHash, String phoneNumber) {
        Guest gu = new Guest(fullName, email, passwordHash, phoneNumber);    
        
        return gu;
    }
}
