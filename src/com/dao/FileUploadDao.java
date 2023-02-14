package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pojo.Filenames;
import com.pojo.ProjectDetails;

public class FileUploadDao {
	public boolean FileUp(UUID guid,String fileName) throws ParseException{
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
		/*ProjectDetails pd = session.get(ProjectDetails.class, guid);
		pd.setFileName(fileName);
		session.update(pd);*/
		String qry = "UPDATE ProjectDetails SET fileName = :fileName WHERE guid = :guid";
		Query q = session.createQuery(qry);
		q.setParameter("fileName", fileName);
		q.setParameter("guid", guid);
		q.executeUpdate();
		status = true;
		t.commit();
		session.close();
		
		return status;
	}

	public boolean inFile(String fileName){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
		
		boolean st;
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		Filenames f = new Filenames();
		f.setFileName(fileName);
		
		session.save(f);
		st = true;
		
		t.commit();
		session.close();
		
		return st;
		
	}
	public boolean chkFile(String fileName){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
		
		boolean st;
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("SELECT COUNT(*) FROM Filenames WHERE fileName = :fname");
		query.setParameter("fname", fileName);
		Long count = (long) query.getFirstResult();
		if(count > 0){
			st = false;
		}else{
			st = true;
		}
		
		
		t.commit();
		session.close();
		
		return st;
		
	}
}
