package com.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.User;

public class LoginDao {
	public User getUser(int userid, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            String hashedPassword = new String(hash, "UTF-8");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
        	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root"); 
			  stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
			  stmt.setInt(1, userid);
			  stmt.setString(2, hashedPassword);
			  rs = stmt.executeQuery();

			  if (rs.next()) {
			    user = new User();
			    user.setId(rs.getInt("id"));
			    user.setUsername(rs.getString("username"));
			    user.setPassword(rs.getString("password"));
			  }
			}catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;

	}
}
