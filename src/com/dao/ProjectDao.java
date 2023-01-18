package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pojo.ProjectDetails;
import com.pojo.User;



public class ProjectDao {
//	public boolean uploadFile(int user_id,int pcode,Date start,Date end,String ptype) throws ParseException{
//		Connection con = null;
//        PreparedStatement pstmt = null;
//        boolean status = false;
//        
//        
//        try{
//        	
//        	Class.forName("oracle.jdbc.driver.OracleDriver");
//        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");
//        	pstmt = con.prepareStatement("INSERT INTO project_details(user_id, p_code, p_start, p_end, p_type) VALUES (?, ?, ?, ?, ?)");
//        	
//        	pstmt.setInt(1, user_id);
//        	pstmt.setInt(2, pcode);
//        	pstmt.setDate(3, start);
//        	pstmt.setDate(4, end);
//        	pstmt.setString(5, ptype);
////        	pstmt.setString(6, fileName);
//        	pstmt.executeUpdate();
//        	
//        	status = true;
//        	
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return status;
//	}
	
	public void inProject(ProjectDetails p, User u){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		session.save(u);
			session.save(p);
        	t.commit();
            session.close();  
	}
}
