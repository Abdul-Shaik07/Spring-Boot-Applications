package com.abdul.java.SpringJDBC.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.abdul.java.SpringJDBC.Dao.MobileDao;
import com.abdul.java.SpringJDBC.Entity.Mobile;


public class MobileDaoImpl implements MobileDao {	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int insertvalues(Mobile mobile) {
		String query = "insert into mobile values(?,?,?)";
		return jdbcTemplate.update(query, mobile.getId(), mobile.getName(), mobile.getPrice());
	}
	//@Override
//	public Mobile getMobile(int id) {
//		RowMapper<Mobile> rowMapper = new RowMapper<Mobile>() {
//			
//			@Override
//			public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Mobile mobile = new Mobile();
//				mobile.setId(rs.getInt(1));
//				mobile.setName(rs.getString(2));
//				mobile.setPrice(rs.getDouble(3));
//				return mobile;
//			}
//		};
//		String query = "select * from mobile";
//		return jdbcTemplate.queryForObject(query, rowMapper, id);
//	}
}
