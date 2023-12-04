package com.sidiabed.hotelservice.Utility;
import java.util.Random;

public class GenerateUserID {
    
    private Random random = new Random();

    public String generateEmployeeID(){
        // Generate a random 4-digit number
        int number = random.nextInt(10000); 
        
        // Format the number to ensure it is 4 digits long. If less than 4 digits pad with 0's
        String formattedNumber = String.format("%04d", number);
        
        return "EM" + formattedNumber;
    }
    
    public String generateGuestID(){
        // Generate a random 4-digit number
        int number = random.nextInt(10000);
        
        // Format the number to ensure it is 4 digits long. If less than 4 digits pad with 0's
        String formattedNumber = String.format("%04d", number); 
        
        // Concatenate with the prefix "GU"
        return "GU" + formattedNumber;
    }
}
