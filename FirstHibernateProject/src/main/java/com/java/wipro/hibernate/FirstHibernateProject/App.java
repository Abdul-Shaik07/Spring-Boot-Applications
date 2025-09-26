package com.java.wipro.hibernate.FirstHibernateProject;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.java.wipro.hibernate.FirstHibernateProject.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Student s = new Student();
        s.setStudent_name("Jerry");
        s.setStudent_Marks(98);
        
        
        Configuration conn = new Configuration();
        conn.configure("hibernate.cfg.xml");
        SessionFactory sf = conn.buildSessionFactory();
        Session openSession = sf.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        
//        SessionFactory sessionFactory = DBUtil.getSessionFactory();
//        
//        Session openSession = sessionFactory.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
        
        	// HQL Query
        /*
        	System.out.println("HQL Query");
        	String query1 = "select s from Student s order by s.student_name";
        	Query<Student> query2 = openSession.createQuery(query1);
        	//query2.setParameter(1, 1);
        	List<Student> resultList = query2.getResultList();
        	for (Student student : resultList) {
				System.out.println(student);
			}
			
			*/
        	
        	// Native Query
       
        	/*
        	 *  System.out.println("Native Query");
        		String nativeQuery = "select * from student where student_id = ?1 ";
        		NativeQuery nativeQuery2 = openSession.createNativeQuery(nativeQuery, Student.class);
        		nativeQuery2.setParameter(1, 1);
        		Student singleResult = (Student) nativeQuery2.getSingleResult();
        		System.out.println(singleResult);
        	
        	 */
        	
        	
        
          	// insert the record
            //openSession.save(s);
         
      
        
        /*
         * get the records
         * 
         Student student = openSession.get(Student.class, 1);
 *       System.out.println(student);
 *  
 */
        
    
        /*
         * update the records
         *    
        Student student = openSession.get(Student.class, 1);
        student.setStudent_name("Ayesha");
        openSession.update(student);
        System.out.println(student);
        
        */
        
        /*
         * Delete the record 
         * 
        Student student = openSession.get(Student.class, 1);
        openSession.delete(student);
        
        */
        
        //Delete a record using HQL Queries
        /*
         * String deleteQuery = "delete from Student s where s.student_id = ?1";
        	Query query = openSession.createQuery(deleteQuery);
        	Query setParameter = query.setParameter(1, 2);
        	int executeUpdate = setParameter.executeUpdate();
        	System.out.println(executeUpdate + "record deleted");
         * 
         */
        
        //DML OPERATION USING HQL 
        
        /*
        String update = "update Student s set s.student_marks = 77 where s.student_id = ?1";
        Query query = openSession.createQuery(update);
        Query setParameter = query.setParameter(1, 2);
        int executeUpdate = setParameter.executeUpdate();
        System.out.println(executeUpdate + " " + "record updated");
        
       */
        
       /*
        String insert = "insert into Student(student_marks, student_name) values(?1,?2)";
        Query query = openSession.createQuery(insert);
        query.setParameter(1, "Mario");
        query.setParameter(2, 5);
        //query.setParameter(3, 68);
        query.executeUpdate();
        System.out.println(query + " " + "record added");
        
       */
        
        
        Criteria c1 = openSession.createCriteria(Student.class);
       
        
        beginTransaction.commit();
        
      
    
    }
}
