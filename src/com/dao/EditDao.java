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
import com.pojo.User;

public class EditDao {
	public List<ProjectDetails> getProjectDetails(String pcode){
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE p_code = :pCode");
		q.setParameter("pCode", pcode);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		
		t.commit();
		session.close();
		
		return details;
		
	}
	public void editProject(ProjectDetails p, User u){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		session.update(u);
		session.update(p);
        t.commit();
        session.close();  
	}
	
}
