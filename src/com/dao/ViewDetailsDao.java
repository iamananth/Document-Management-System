package com.dao;

import java.time.LocalDate;
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
		
		if(user_id == 144){
			@SuppressWarnings("rawtypes")
			Query q = session.createQuery("FROM ProjectDetails");
			@SuppressWarnings("unchecked")
			List<ProjectDetails> details = q.list();
			t.commit();
			return details;
		}else{
			@SuppressWarnings("rawtypes")
			Query q = session.createQuery("FROM ProjectDetails WHERE user_id = :userId");
			q.setParameter("userId", user_id);
			@SuppressWarnings("unchecked")
			List<ProjectDetails> details = q.list();
			t.commit();
			return details;
		}
		
	}
	
	public List<ProjectDetails> getArchived(int user_id){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		LocalDate date = java.time.LocalDate.now();
		String cDate = date.toString();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE user_id = :userid AND endDate <= :cDate");
		q.setParameter("userid", user_id);
		q.setParameter("cDate", cDate);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		t.commit();
		session.close();
		
		return details;
	}
	
	public List<ProjectDetails> getOngoing(int user_id){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();

		String cDate = java.time.LocalDate.now().toString();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE user_id = :userid AND endDate >= :cDate");
		q.setParameter("userid", user_id);
		q.setParameter("cDate", cDate);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		t.commit();
		session.close();
		
		return details;
	}
	
	public List<ProjectDetails> AllOngoing(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();

		String cDate = java.time.LocalDate.now().toString();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE endDate >= :cDate");
		q.setParameter("cDate", cDate);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		t.commit();
		
		return details;
	}
	
	public List<ProjectDetails> AllArchived(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();

		String cDate = java.time.LocalDate.now().toString();
		
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("FROM ProjectDetails WHERE endDate <= :cDate");
		q.setParameter("cDate", cDate);
		@SuppressWarnings("unchecked")
		List<ProjectDetails> details = q.list();
		
		t.commit();
		
		return details;
	}
	
}
