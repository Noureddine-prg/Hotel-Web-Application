package com.sidiabed.hotelservice.Utility;

import java.util.Random;
public class GenerateUserID {
    
    private static Random random = new Random();

    public static String generateEmployeeID(){
        int number = random.nextInt(10000); 
        String formattedNumber = String.format("%04d", number);
        return "EM" + formattedNumber;
    }

    public static String generateGuestID(){
        int number = random.nextInt(10000);
        String formattedNumber = String.format("%04d", number); 
        return "GU" + formattedNumber;
    }
}
