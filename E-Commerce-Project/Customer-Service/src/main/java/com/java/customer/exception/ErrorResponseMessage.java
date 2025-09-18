package com.java.customer.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponseMessage {
    private String message;
    private String status;
    private LocalDateTime localDateTime;

    public ErrorResponseMessage(String message, String status) {
        this.message = message;
        this.status = status;
        localDateTime = LocalDateTime.now();
    }

}
