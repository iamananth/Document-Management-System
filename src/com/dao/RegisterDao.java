package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.security.MessageDigest;

public class RegisterDao {
	public boolean insert(String uname, String pass, String dept, String ph){
		Connection con = null;
        PreparedStatement pstmt = null;
        boolean status = false;
        
        try{
        	 MessageDigest md = MessageDigest.getInstance("MD5");
             byte[] hash = md.digest(pass.getBytes());
             String hashedPassword = new String(hash, "UTF-8");
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
        	pstmt = con.prepareStatement("INSERT INTO users(username, password, department, phone_number) VALUES (?, ?, ?, ?)");
        	
        	pstmt.setString(1, uname);
        	pstmt.setString(2, hashedPassword);
        	pstmt.setString(3, dept);
        	pstmt.setString(4, ph);
        	pstmt.executeUpdate();
        	
        	status = true;
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
		return status;
	}
}
