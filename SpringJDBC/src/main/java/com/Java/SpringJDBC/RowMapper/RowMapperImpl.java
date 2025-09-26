package com.Java.SpringJDBC.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import com.Java.SpringJDBC.Dao.HostelDao;
import com.Java.SpringJDBC.Dao.HostelDaoImpl;
import com.Java.SpringJDBC.Entity.Hostel;

public class RowMapperImpl implements org.springframework.jdbc.core.RowMapper<Hostel> {
	@Override
	public Hostel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hostel hostel = new Hostel();
		hostel.setRoomNo(rs.getInt(1));
		hostel.setFName(rs.getString(2));
		hostel.setFloorNo(rs.getInt(3));
		return hostel;
	}

	

	

}
