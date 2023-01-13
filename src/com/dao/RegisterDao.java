package com.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pojo.User;

public class RegisterDao {
//	public boolean insert(String uname, String pass, String dept, String ph){
//		Connection con = null;
//        PreparedStatement pstmt = null;
//        boolean status = false;
//        
//        try{
//        	 MessageDigest md = MessageDigest.getInstance("MD5");
//             byte[] hash = md.digest(pass.getBytes());
//             String hashedPassword = new String(hash, "UTF-8");
//        	
//        	Class.forName("oracle.jdbc.driver.OracleDriver");
//        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
//        	pstmt = con.prepareStatement("INSERT INTO users(username, password, department, phone_number) VALUES (?, ?, ?, ?)");
//        	
//        	pstmt.setString(1, uname);
//        	pstmt.setString(2, hashedPassword);
//        	pstmt.setString(3, dept);
//        	pstmt.setString(4, ph);
//        	pstmt.executeUpdate();
//        	
//        	status = true;
//        	
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return status;
//	}
	
	public void register(User u){        
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();  
		
		try{
			session.save(u);
		}catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
        	t.commit();
            session.close();
        }   
		        
		   
		 }    
}
