package com.Java.SpringJDBC.Dao;

import com.Java.SpringJDBC.Entity.Hostel;

public interface HostelDao {
	//public int insert(Hostel hostel);
	public Hostel getHostel(String name);
	
}
