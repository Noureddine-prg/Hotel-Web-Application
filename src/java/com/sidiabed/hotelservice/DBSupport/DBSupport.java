package com.sidiabed.hotelservice.DBSupport;

import java.util.Properties;
import java.sql.*;  


public class DBSupport {
    
    public static Connection establishConnection() throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Properties connectProp = new Properties();
        connectProp.put("dbms","mysql");
        connectProp.put("user","root");
        connectProp.put("password","password");
        connectProp.put("useSSL","false");         
        String P1 = "jdbc:mysql://localhost:3306/HotelDB";
        conn = DriverManager.getConnection(P1,connectProp);
        return conn;
    }
    
    public static void executeQuery(String q) throws SQLException, ClassNotFoundException{        
        Connection conn = establishConnection();
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE HotelDB");
        Statement queryStatement = conn.createStatement();
        queryStatement.execute(q); 
        conn.close();
                
    }
    
    public static ResultSet fetchResultSet(String q) throws SQLException, ClassNotFoundException{
        Connection conn = establishConnection();
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE HotelDB");
        
        Statement queryStatement = conn.createStatement();
        ResultSet rs = queryStatement.executeQuery(q);
        
        return rs;    
        
    }
    

    
}
