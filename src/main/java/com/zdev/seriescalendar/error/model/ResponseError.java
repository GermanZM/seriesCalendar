package com.zdev.seriescalendar.error.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseError {
	
	private HttpStatus status;
	private int statusCode;
	private String message;
	private List<String> errors = new ArrayList<String>();
	
	public ResponseError(HttpStatus status) {
        super();
        this.status = status;
        this.statusCode = this.status.value();
    }
	
	public ResponseError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.statusCode = this.status.value();
        this.message = message;
    }
	
	public ResponseError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.statusCode = this.status.value();
        this.message = message;
        this.errors = errors;
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
