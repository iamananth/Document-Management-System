package com.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ForgotPassDao {
	public boolean changePass(String id,String pass){
		Connection con = null;
        PreparedStatement pstmt = null;
        boolean status = false;
        
        try{
        	MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(pass.getBytes());
            String hashedPassword = new String(hash, "UTF-8");
            

        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
        	pstmt = con.prepareStatement("UPDATE users SET password = ? WHERE id = ?");
        	pstmt.setString(1, hashedPassword);
        	pstmt.setString(2, id);
        	pstmt.executeUpdate();
        	
        	status = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
		return status;
	}
}
