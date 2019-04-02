package com.patabendi.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.patabendi.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	//@Override
    public Response toResponse(DataNotFoundException exception) {
    	
    	ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage(),
                ErrorMessages.NO_RECORD_FOUND.name()
        );
        
        return Response.status(Response.Status.BAD_REQUEST).
                entity(errorMessage).
                build();
    	
    }
	
}
