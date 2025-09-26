package com.java.hibernate;

import java.io.Serializable;
import java.lang.module.ModuleDescriptor.Opens;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//        Index i = new Index();
//        i.setA(1);
//        i.setB("Abbu");
//        
//        Configuration con = new Configuration();
//        con.configure("com/java/hibernate/hibernate.cfg.xml");
//        SessionFactory sessionFactory = con.buildSessionFactory();
//        Session openSession = sessionFactory.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        openSession.save(i);
//        beginTransaction.commit();
//        sessionFactory.close();
//        openSession.close();
        
        
        	Mobile mobile = new Mobile();
        	mobile.setMobileId(1);
        	mobile.setMobileName("Iphone");
        	mobile.setMobilePrice(56567.34);
        	
        	Mobile mobile1 = new Mobile();
        	mobile1.setMobileId(1);
        	mobile1.setMobileName("OnePlus");
        	mobile1.setMobilePrice(46457.12);
        	
        	Mobile mobile2 = new Mobile();
        	mobile2.setMobileId(1);
        	mobile2.setMobileName("realme");
        	mobile2.setMobilePrice(26381.67);
        	Configuration con = new Configuration();
        	con.configure("com/java/hibernate/hibernate.cfg.xml");
        	SessionFactory sessionFactory = con.buildSessionFactory();
        	Session openSession = sessionFactory.openSession();
//        	Mobile mobile = openSession.get(Mobile.class, 2);
//        	System.out.println(mobile);
        	openSession.remove(mobile);
//        	mobile.setMobileName("Realme");
//        	openSession.update(mobile);
        	//openSession.delete(mobile);
        	
        	
        	
        	//Query query = openSession.createQuery("from Mobile where mobileId=1");
//        	List list = query.list();
//        	for (Object object : list) {
//        		System.out.println(object);
//				
//			}
//        	Object uniqueResult = query.uniqueResult();
//        	System.out.println(uniqueResult);
        	
        	Transaction beginTransaction = openSession.beginTransaction();
        	//openSession.save(mobile2);   
        	beginTransaction.commit();
        	openSession.close();
        	sessionFactory.close();
    }
}
