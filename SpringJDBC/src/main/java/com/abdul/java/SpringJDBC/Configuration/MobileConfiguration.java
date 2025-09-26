package com.abdul.java.SpringJDBC.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.abdul.java.SpringJDBC.DaoImpl.MobileDaoImpl;
import com.abdul.java.SpringJDBC.Entity.Mobile;

@Configuration
public class MobileConfiguration {
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
	@Bean("mobileDaoImpl")
	public MobileDaoImpl getMobileDaoImpl(){
		MobileDaoImpl mobileDaoImpl = new MobileDaoImpl();
		mobileDaoImpl.setJdbcTemplate(getJdbcTemplate());
		return mobileDaoImpl;
	}
	@Bean("mobile") 
	public Mobile getMobile() {
		Mobile mobile = new Mobile();
		mobile.setId(1);
		mobile.setName("Oneplus");
		mobile.setPrice(34523.67);
		return mobile;
		
	}
	@Bean("mobile1") 
	public Mobile getMobile1() {
		Mobile mobile1 = new Mobile();
		mobile1.setId(2);
		mobile1.setName("IPhone");
		mobile1.setPrice(65523.67);
		return mobile1;
		
	}
	@Bean("mobile2") 
	public Mobile getMobile2() {
		Mobile mobile2 = new Mobile();
		mobile2.setId(3);
		mobile2.setName("Pixel");
		mobile2.setPrice(32553.87);
		return mobile2;
		
	}
}
