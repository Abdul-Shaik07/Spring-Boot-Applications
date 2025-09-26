package com.java.product.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Player {
	@Id
	private int id;
	private String name;
	private String email;
	private String mobile;
	private double height;
	private double weight;
	private String type;
}
