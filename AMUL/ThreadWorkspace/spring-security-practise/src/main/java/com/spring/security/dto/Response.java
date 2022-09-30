package com.spring.security.dto;

public class Response {

	public Object object;
	public String status;
	public int statusCode;
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "Response [object=" + object + ", status=" + status + ", statusCode=" + statusCode + "]";
	}
	
	
}
