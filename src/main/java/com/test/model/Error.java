package com.test.model;

public class Error {

	private int errorNo;
	private String errorMessage;
	public Error(){
		
	}
	public Error(int n, String m){
		errorNo=n;
		errorMessage=m;
	}
	public int getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
