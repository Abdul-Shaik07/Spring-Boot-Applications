package com.java.hibernate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Index {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a;
	private String b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "Index [a=" + a + ", b=" + b + "]";
	}
}
