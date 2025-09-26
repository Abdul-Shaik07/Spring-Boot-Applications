package com.Java.SpringJDBC.Entity;

public class Hostel {

	private int roomNo;
	private String fname;
	private int floorNo;
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getFName() {
		return fname;
	}
	public void setFName(String fname) {
		this.fname = fname;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public Hostel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Hostel [roomNo=" + roomNo + ", fname=" + fname + ", floorNo=" + floorNo + "]";
	}
	

}
