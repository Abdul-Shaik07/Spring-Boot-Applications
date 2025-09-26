package com.abdul.java.SpringJDBC.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.abdul.java.SpringJDBC.DaoImpl.ProductDaoImpl;
import com.abdul.java.SpringJDBC.Entity.Product;
@Configuration
public class ProductConfiguration {
	@Bean("driverManagerDataSource")
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("abbu123");
		return driverManagerDataSource;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManagerDataSource());
		return jdbcTemplate;
	}
	@Bean("productDaoImpl")
	public ProductDaoImpl getProductDaoImpl() {
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.setJdbcTemplate(getJdbcTemplate());
		return productDaoImpl;
	}
	@Bean("product")
	public Product getProduct() {
		Product product = new Product();
		product.setpId(1);
		product.setpName("Lux");
		product.setpPrice(45.34);
		return product;	
	}
	@Bean("product1")
	public Product getProduct1() {
		Product product1 = new Product();
		product1.setpId(2);
		product1.setpName("Mysore Sandal");
		product1.setpPrice(90.21);
		return product1;
	}
	@Bean("product2")
	public Product getProduct2() {
		Product product2 = new Product();
		product2.setpId(3);
		product2.setpName("Chintol");
		product2.setpPrice(52.60);
		return product2;
		
	}
}
