package com.Java.SpringJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.Java.SpringJDBC.Configuration.HostelConfiguration;
import com.Java.SpringJDBC.Dao.HostelDaoImpl;
import com.Java.SpringJDBC.Entity.Hostel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(HostelConfiguration.class);
        HostelDaoImpl bean = context.getBean("hostelDaoImpl", HostelDaoImpl.class);
        Hostel hostel = context.getBean("hostel", Hostel.class);
        Hostel hostel2 = bean.getHostel("Shaik");
        System.out.println(hostel2);
    }
}
