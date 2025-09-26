package com.wipro.spring.entity;

import java.sql.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Table(name = "bus_info")
public class Bus {
	@Id
	private long busId;
	private String busName;
	private long ticketId;
	private double ticketPrice;
	private String departureDate;	
	private String arrivalDate;
	private long mobileNumber;

}
