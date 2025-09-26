package com.java.bookstore.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class BookStore {
	private long bookId;
	@Id
	private String bookName;
	private double bookPrice;
	private Date date;
	private long mobileNumber;
//	public long getBookId() {
//		return bookId;
//	}
//	public void setBookId(long bookId) {
//		this.bookId = bookId;
//	}
//	public String getBookName() {
//		return bookName;
//	}
//	public void setBookName(String bookName) {
//		this.bookName = bookName;
//	}
//	public double getBookPrice() {
//		return bookPrice;
//	}
//	public void setBookPrice(double bookPrice) {
//		this.bookPrice = bookPrice;
//	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	public long getMobileNumber() {
//		return mobileNumber;
//	}
//	public void setMobileNumber(long mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//	public BookStore() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public BookStore(long bookId, String bookName, double bookPrice, Date date, long mobileNumber) {
//		super();
//		this.bookId = bookId;
//		this.bookName = bookName;
//		this.bookPrice = bookPrice;
//		this.date = date;
//		this.mobileNumber = mobileNumber;
//	}
//	@Override
//	public String toString() {
//		return "BookStore [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", date=" + date
//				+ ", mobileNumber=" + mobileNumber + "]";
	}
	

