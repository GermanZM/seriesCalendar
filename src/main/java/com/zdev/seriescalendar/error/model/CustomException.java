package com.zdev.seriescalendar.error.model;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ResponseError responseError;
	
	public CustomException(ResponseError responseError, Exception e) {
		super(e);
		this.responseError = responseError;
	}
	
	public CustomException(ResponseError responseError, String customMsgError, Exception e) {
		super(customMsgError, e);
		this.responseError = responseError;
		this.responseError.setMessage(customMsgError);
	}
	
	public ResponseError getResponseError() {
		return this.responseError;
	}
	
	

}
