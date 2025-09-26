package com.abdul.java.SpringJDBC;

import java.text.Annotation;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abdul.java.SpringJDBC.Configuration.MobileConfiguration;
import com.abdul.java.SpringJDBC.Configuration.ProductConfiguration;
import com.abdul.java.SpringJDBC.Dao.ProductDao;
import com.abdul.java.SpringJDBC.DaoImpl.MobileDaoImpl;
import com.abdul.java.SpringJDBC.DaoImpl.ProductDaoImpl;
import com.abdul.java.SpringJDBC.Entity.Mobile;
import com.abdul.java.SpringJDBC.Entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MobileConfiguration.class);
//        MobileDaoImpl bean = annotationConfigApplicationContext.getBean("mobileDaoImpl", MobileDaoImpl.class);
//        Mobile bean2 = annotationConfigApplicationContext.getBean("mobile", Mobile.class);
//        Mobile bean3 = annotationConfigApplicationContext.getBean("mobile1", Mobile.class);
//        Mobile bean4 = annotationConfigApplicationContext.getBean("mobile2", Mobile.class);
//        int res = bean.insertvalues(bean2);
//        int res1 = bean.insertvalues(bean3);
//        int res2 = bean.insertvalues(bean4);
//        //System.out.println("Deleted");
//        System.out.println(res);
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println("byee");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        ProductDaoImpl bean0 = applicationContext.getBean("productDaoImpl", ProductDaoImpl.class);
        List<Product> productTable = bean0.getProductTable();
        for (Product product : productTable) {
			System.out.println(product);
		}
//		  System.out.println(bean0.getProductQuery(2));
//        Product bean00 = applicationContext.getBean("product", Product.class);
//        Product bean01 = applicationContext.getBean("product1", Product.class);
//        Product bean02 = applicationContext.getBean("product2", Product.class);
//        bean0.createProduct(bean00);     
//        bean0.insertProductValues(bean01);
//        bean0.insertProductValues(bean02);
        
    }
}
