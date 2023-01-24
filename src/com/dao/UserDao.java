package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

public class UserDao {
	 public List<User> getUsersFromDatabase() {
	    List<User> users = new ArrayList<>();
	    
	    Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
	    
	    try 
        {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root");   
            stmt = con.createStatement();  
            rs = stmt.executeQuery("select * from users"); 
            
            while (rs.next()) 
            {  
            	User user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUsername(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setDepartment(rs.getString("department"));
            	user.setPhone_number(rs.getString("phone_number"));
                users.add(user);
            } 
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, Statement, and Connection objects
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
	 
	 public List<User> getUserDetails(int id){
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			  
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			
			@SuppressWarnings("rawtypes")
			Query q = session.createQuery("FROM User WHERE id = :id");
			q.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<User> details = q.list();
			
			t.commit();
			session.close();
			
			return details;
			
		}
	 public void upUser(int id,String uname,String dept, String ph){
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			  
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			
			Query q = session.createQuery("UPDATE User SET username = :uname, department = :dept, phone_number = :ph WHERE id = :id");
			q.setParameter("uname", uname);
			q.setParameter("dept", dept);
			q.setParameter("ph", ph);
			q.setParameter("id", id);
			
			q.executeUpdate();
			
			t.commit();
			session.close();
		}
	 public boolean deleteUser(int id){
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			  
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			boolean status = false;
			
			String qry = "DELETE User WHERE id = :id";
			
			Query q = session.createQuery(qry);
			q.setParameter("id", id);
			q.executeUpdate();
			status = true;
			t.commit();
			session.close();
			
			return status;
		}
}
