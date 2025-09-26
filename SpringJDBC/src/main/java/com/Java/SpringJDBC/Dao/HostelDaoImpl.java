package com.Java.SpringJDBC.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Java.SpringJDBC.Entity.Hostel;
import com.Java.SpringJDBC.RowMapper.RowMapperImpl;

public class HostelDaoImpl implements HostelDao {
	private JdbcTemplate jdbcTemplate;
	
//	@Override
//	public int insert(Hostel hostel) {
//		String query = "insert into hostel values(?,?,?)";
//		return jdbcTemplate.update(query, hostel.getRoomNo(), hostel.getFName(), hostel.getFloorNo());
//		
//	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
//	@Override
//	public Hostel getHostel(String name) {
//		RowMapperImpl rowMapperImpl = new RowMapperImpl();
//		String query = "select roomNo from hostel where name = ?"; 
//		return jdbcTemplate.queryForObject(query, rowMapperImpl, name);
//	}
//	
	@Override
	public Hostel getHostel(String name) {
		RowMapper<Hostel> rowMapper = new RowMapperImpl();
		String query = "Select * from hostel where fname=?";
		return jdbcTemplate.queryForObject(query, rowMapper, name);
	}
	

	
	

}
