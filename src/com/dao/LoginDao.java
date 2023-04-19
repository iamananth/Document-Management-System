package com.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.pojo.User;

public class LoginDao {
//	public User getUser(int userid, String password) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		User user = null;
//		try {
//			
//			MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] hash = md.digest(password.getBytes());
//            String hashedPassword = new String(hash, "UTF-8");
//			
//			Class.forName("oracle.jdbc.driver.OracleDriver");  
//        	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root"); 
//			  stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
//			  stmt.setInt(1, userid);
//			  stmt.setString(2, hashedPassword);
//			  rs = stmt.executeQuery();
//
//			  if (rs.next()) {
//			    user = new User();
//			    user.setId(rs.getInt("id"));
//			    user.setUsername(rs.getString("username"));
//			    user.setPassword(rs.getString("password"));
//			  }
//			}catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return user;
//
//	}
	
	public User login(int userid, String password){
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		 SessionFactory factory = meta.getSessionFactoryBuilder().build();
		 Session session = factory.openSession();
		 User user = null;
	        try {
	            @SuppressWarnings("rawtypes")
				Query query = session.createQuery("FROM User WHERE id = :userid AND password = :password");
	            query.setParameter("userid", userid);
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] hash = md.digest(password.getBytes());
	            String hashedPassword = new String(hash, "UTF-8");
	            query.setParameter("password", hashedPassword);
	            user = (User) query.uniqueResult();
	        }catch(Exception e){
	        	e.printStackTrace();
	        }finally {
	            session.close();
	        }
	        return user;
	}
}
