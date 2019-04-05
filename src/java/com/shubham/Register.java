/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shubham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author shubham
 */
public class Register {
    
     static String url="jdbc:mysql://localhost:3306/restdb";
   static String user="root";
   
    public String signUp(String username,String firstname,String lastname,String email,String password)
    {
        Register r=new Register();
        JSONObject obj = new JSONObject();
       
        //code for creating mysql connection
        try {
            
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(url,user,"");
          PreparedStatement ps= con.prepareStatement("select * from register where username='"+username+"'");
          
          ResultSet rs=ps.executeQuery();
           
            if (rs.next() == false) { 
                
               //code for insertion of user in register table
              PreparedStatement ps1= con.prepareStatement("insert into register (username,firstname,lastname,email, password) VALUES( ?,?,?,?,?) ");
             
              ps1.setString(1, username);
                ps1.setString(2, firstname);
                   ps1.setString(3, lastname);
                      ps1.setString(4, email);
                         ps1.setString(5, password);
              int i =ps1.executeUpdate();
              if(i!=0){
                  
                 obj.put("result","true");
         obj.put("message", "User Register Successfully!");
         
        JSONArray data = new JSONArray();
        JSONObject obj1=new JSONObject();
        obj1.put("username", username);
        //r.generateSession(10);
        obj1.put("token",r.generateSession(20));
        data.add(obj1);
        obj.put("data", data);
        
                  //successful 
                  
              }
              
              con.close();
            } else {
                
                obj.put("result","false");
         obj.put("message", "User Already Registered!"); }


         
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        
        //code ends here
        return obj.toString();
    }

  
public  String generateSession(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
}
  
