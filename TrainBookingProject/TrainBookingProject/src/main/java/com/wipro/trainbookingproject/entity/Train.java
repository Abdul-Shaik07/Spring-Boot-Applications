package com.wipro.trainbookingproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Train {
	@Id
	private long trainNumber;
	//@NotNull
	private String trainName;
	private long ticketId;
	//@NotNull
	private String passengerName;
	//@Min(value = 500)
	private double ticketPrice;
	private LocalDate departureTime;
	private LocalDate arrivalTime;
	//@Max(value = 10)
	private long mobileNumber;
	//@Email
	private String email;
	private String sourceStation;
	private String destinationStation;
	

	

}
