package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.pojo.ProjectDetails;


public class ViewDetailsDao {
	
	public List<ProjectDetails> getProjectDetails(int user_id){
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE user_id = :userId");
		q.setParameter("userId", user_id);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		
		t.commit();
		session.close();
		
		return details;
		
	}
	
	
}
