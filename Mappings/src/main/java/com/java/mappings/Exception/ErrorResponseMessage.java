package com.java.mappings.Exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
public class ErrorResponseMessage {
	
	private String reason;
	private String status;
	private LocalDateTime localDateTime;
	public ErrorResponseMessage(String reason, String status) {
		this.reason = reason;
		this.status = status;
		this.localDateTime = LocalDateTime.now();
	}

}
