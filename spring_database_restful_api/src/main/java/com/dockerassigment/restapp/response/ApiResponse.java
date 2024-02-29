package com.dockerassigment.restapp.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResponse<T> {
    private boolean status;
    private T content;
    private String message;
    private String timestamp = formatTimestamp(LocalDateTime.now());    // Representing time stamp as a string in the desired format

    // Getters and setters
    public boolean isStatus() {
        return status;
    }

    public ApiResponse() {
		super();
	}

	public void setStatus(boolean status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // Format time stamp using the desired format
    private String formatTimestamp(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss"); // Format: dd/Mon/yyyy HH:mm:ss
        return dateTime.format(formatter);
    }
}
