package com.dao;


import java.text.ParseException;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FileUploadDao {
	public boolean FileUp(String pcode,String fileName) throws ParseException{
//		Connection con = null;
//        PreparedStatement pstmt = null;
//        boolean status = false;
//        
//        
//        try{
//        	
//        	Class.forName("oracle.jdbc.driver.OracleDriver");
//        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
//        	pstmt = con.prepareStatement("UPDATE project_details SET file_name = ? WHERE p_code = ?");
//        	pstmt.setString(1, fileName);
//        	pstmt.setString(2, pcode);
//        	pstmt.executeUpdate();
//        	
//        	status = true;
//        	
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return status;
		
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		boolean status = false;
		String qry = "UPDATE ProjectDetails SET file_name = :fileName WHERE p_code = :pCode";
		
		Query q = session.createQuery(qry);
		q.setParameter("fileName",fileName);
		q.setParameter("pCode", pcode);
		q.executeUpdate();
		status = true;
		t.commit();
		session.close();
		
		return status;
	}
}
