package com.Java.SpringJDBC.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Java.SpringJDBC.Dao.HostelDaoImpl;
import com.Java.SpringJDBC.Entity.Hostel;

@Configuration
public class HostelConfiguration {
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("abbu123");
		return driverManagerDataSource;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManagerDataSource());
		return jdbcTemplate;
	}
	@Bean("hostelDaoImpl")
	public HostelDaoImpl getHostelDaoImpl() {
		HostelDaoImpl h = new HostelDaoImpl();
		h.setJdbcTemplate(getJdbcTemplate());
		return h;
	}
	@Bean("hostel")
	public Hostel getHostel() {
		Hostel hostel = new Hostel();
		hostel.setRoomNo(421);
		hostel.setFName("Abdul");
		hostel.setFloorNo(3);
		return hostel;
	}

}
