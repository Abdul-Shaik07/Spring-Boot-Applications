package com.abdul.java.SpringORM.Configuration;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.abdul.java.SpringORM.DaoImpl.ProductDaoImpl;
import com.abdul.java.SpringORM.Entity.Product;
@Configuration
public class ProductConfiguration {
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springorm");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("abbu123");
		return driverManagerDataSource;
	}
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDriverManagerDataSource());
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setAnnotatedClasses(Product.class);
		return localSessionFactoryBean;
	}
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	@Bean("productDaoImpl")
	public ProductDaoImpl getProductDaoImpl() {
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.setHibernateTemplate(getHibernateTemplate());
		return productDaoImpl;
	}
	@Bean("product")
	public Product getProduct() {
		Product product = new Product();
		product.setpName("Lux");
		product.setpPrice(56.34);
		return product;
	}
	@Bean("product1")
	public Product getProduct1() {
		Product product1 = new Product();
		product1.setpName("Santoor");
		product1.setpPrice(46.12);
		return product1;
	}
	@Bean("product2")
	public Product getProduct2() {
		Product product2 = new Product();
		product2.setpName("Liril");
		product2.setpPrice(73.11);
		return product2;
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTransactionManager;
	}
}
