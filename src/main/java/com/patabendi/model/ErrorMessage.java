package com.patabendi.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessageValue;
    private String errorMessageKey;
    
	public ErrorMessage() {

	}

	public ErrorMessage(String errorMessageValue, String errorMessageKey) {
		this.errorMessageValue = errorMessageValue;
		this.errorMessageKey = errorMessageKey;
	}

	public String getErrorMessageValue() {
		return errorMessageValue;
	}

	public void setErrorMessageValue(String errorMessageValue) {
		this.errorMessageValue = errorMessageValue;
	}

	public String getErrorMessageKey() {
		return errorMessageKey;
	}

	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}
    
	
    

}
