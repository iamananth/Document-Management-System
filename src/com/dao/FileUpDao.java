package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class FileUpDao {

    public boolean addFile(String pCode, List<String> fileNames) {
        Session session = null;
        Transaction transaction = null;
        boolean status = false;
        	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    		  
    		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    		session = factory.openSession();
    		transaction = session.beginTransaction();
            
            String fname = StringUtils.join(fileNames , ',');
            System.out.println(fname);
            
            String qry = "UPDATE ProjectDetails SET file_name = :fileName WHERE p_code = :pCode";
            Query q = session.createQuery(qry);
    		q.setParameter("fileName", fname);
    		q.setParameter("pCode", pCode);
    		q.executeUpdate();
            transaction.commit();
            status = true;
            session.close();
        
        return status;
    }
}

