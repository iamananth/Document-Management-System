package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;

public class UserDao {
	 public List<User> getUsersFromDatabase() {
	    List<User> users = new ArrayList<>();
	    
	    Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
	    
	    try 
        {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");   
            stmt = con.createStatement();  
            rs = stmt.executeQuery("select * from users"); 
            
            while (rs.next()) 
            {  
            	User user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUsername(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setDepartment(rs.getString("department"));
            	user.setPhone_number(rs.getString("phone_number"));
                users.add(user);
            } 
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, Statement, and Connection objects
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
