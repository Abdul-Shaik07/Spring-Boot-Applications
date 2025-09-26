package com.wipro.busbookingproject.entity;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busId;
	
	@NotBlank(message = "busName field is mandatory")
	private String busName;
	
	@NotNull(message = "ticketId is mandatory")
	@Min(1)
	@Max(100)
	private Long ticketId;
	
	@NotNull(message = "ticketPrice is mandatory")
	@DecimalMin(value = "100.00", message = "Price should be more than equal to 100.00")
	@DecimalMax(value = "2999.00", message = "Price should be less than equal to 2999.00")
	private Double ticketPrice;
	
	@NotNull(message = "DepartureDate is required")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;	
	
	@NotNull(message = "ArrivalDate is required")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivalDate;
	
	@NotBlank(message = "Mobile Number is required")
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid Mobile Number")
	private String mobileNumber;

}
