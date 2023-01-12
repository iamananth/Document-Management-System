package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;

public class FileUploadDao {
	public boolean FileUp(String pcode,String fileName) throws ParseException{
		Connection con = null;
        PreparedStatement pstmt = null;
        boolean status = false;
        
        
        try{
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
        	pstmt = con.prepareStatement("UPDATE project_details SET file_name = ? WHERE p_code = ?");
        	pstmt.setString(1, fileName);
        	pstmt.setString(2, pcode);
        	pstmt.executeUpdate();
        	
        	status = true;
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
		return status;
	}
}
