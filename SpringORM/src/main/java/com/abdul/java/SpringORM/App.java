package com.abdul.java.SpringORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abdul.java.SpringORM.Configuration.ProductConfiguration;
import com.abdul.java.SpringORM.DaoImpl.ProductDaoImpl;
import com.abdul.java.SpringORM.Entity.Product;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProductConfiguration.class);
        ProductDaoImpl bean = applicationContext.getBean("productDaoImpl", ProductDaoImpl.class);
        Product bean1 = applicationContext.getBean("product", Product.class);
        Product bean2 = applicationContext.getBean("product1", Product.class);
        Product bean3 = applicationContext.getBean("product2", Product.class);
        bean.insertProduct(bean1);
        bean.insertProduct(bean2);
        bean.insertProduct(bean3);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);
        
        
        
    }
}
