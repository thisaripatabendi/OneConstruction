package com.patabendi.exceptions;

public enum ErrorMessages {
	
    NO_RECORD_FOUND("No record found for provided id"),
    NO_RECORDS_FOUND("No record found"),
    CANNOT_DELETE_RECORD("Cannot delete record, there can be projects or employees listed under the record"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Something went wrong. Please repeat this operation later.");
    
    private String errorMessage;
   
    ErrorMessages(String errorMessage){
      this.errorMessage = errorMessage;    
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
