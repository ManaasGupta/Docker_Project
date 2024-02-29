package com.dockerassigment.restapp.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ExceptionApiResponse {
	
	private String timestamp = formatTimestamp(LocalDateTime.now());    // Representing time stamp as a 
	private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
	private boolean status = false;
	private String message;
	
	private String formatTimestamp(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss"); // Format: dd/Mon/yyyy HH:mm:ss
        return dateTime.format(formatter);
    }
}
