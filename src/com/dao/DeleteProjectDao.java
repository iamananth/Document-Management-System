package com.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DeleteProjectDao {
	public boolean deleteProject(String pcode){
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		boolean status = false;
		
		String qry = "DELETE ProjectDetails WHERE p_code = :pCode";
		
		Query q = session.createQuery(qry);
		q.setParameter("pCode", pcode);
		q.executeUpdate();
		status = true;
		t.commit();
		session.close();
		
		return status;
	}
}
