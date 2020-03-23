package weptest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Entity.Message;

public class ConnectDB {
	
	Message mes;
	
	
	public ConnectDB() {
		
	}
	
	public void getConnect(Message mes) {
	 
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Message.class)
				.buildSessionFactory();
//create session
this.mes=mes;
 	Session session = factory.getCurrentSession();
try {			
//create a student object
	
System.out.println("Creating new student object...");

//start a transaction
session.beginTransaction();
session.save(mes);

session.getTransaction().commit();
		
		}
	catch (Exception exc) {
			exc.printStackTrace();
		}
finally {
	session.close();
	factory.close();
 }
}
}
