package com.hibernate.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf = null;
    	Session session = null;
    	try {
    	Configuration config = new Configuration();
    	sf = config.configure("hibernate.cfg.xml").buildSessionFactory();
    	session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	//Employee emp = (Employee) session.get(Employee.class, 20);
    	Employee emp = (Employee) session.load(Employee.class, 20);
    	tx.commit();
    	if(emp==null) {
    	System.out.println("Employee doesn't exist...");
    	}
    	else {
    		System.out.println("Employee Details"); 
    		System.out.println("---------------------"); 
    		System.out.println("Employee Id :"+emp.getEid()); 
    		System.out.println("Employee Name :"+emp.getEname());
    		System.out.println("Employee Address :"+emp.getEaddress()); 
    	}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    	sf.close();
    	}
    }
}
