package com.shaji.javaee.controller.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shaji.javaee.controller.rest.exceptions.DatabaseErrorException;
import com.shaji.javaee.controller.rest.exceptions.InvalidLoginException;
import com.shaji.javaee.controller.rest.exceptions.InvalidPayloadException;
import com.shaji.javaee.controller.rest.exceptions.NoAccessException;
import com.shaji.javaee.controller.rest.exceptions.RecordNotFoundException;

@ControllerAdvice
public class RestApiErrorHandler {

	@ExceptionHandler(InvalidLoginException.class)
	private ResponseEntity<RestApiError> rulesForInvalidLogin(Exception e) {
		RestApiError restError = new RestApiError("Invalid login");
		return new ResponseEntity<RestApiError>(restError, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(InvalidPayloadException.class)
	private ResponseEntity<RestApiError> rulesForInvalidPayload(Exception e) {
		RestApiError restError = new RestApiError("Invalid Payload : " + e.getMessage());
		return new ResponseEntity<RestApiError>(restError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	private ResponseEntity<RestApiError> rulesForRecordNotFound(Exception e) {
		RestApiError restError = new RestApiError("Record not found : " + e.getMessage());
		return new ResponseEntity<RestApiError>(restError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoAccessException.class)
	private ResponseEntity<RestApiError> rulesForNoAccess(Exception e) {
		RestApiError restError = new RestApiError("Not allowed : " + e.getMessage());
		return new ResponseEntity<RestApiError>(restError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DatabaseErrorException.class)
	private ResponseEntity<RestApiError> rulesForDatabaseError(Exception e) {
		RestApiError restError = new RestApiError("Database Error : " + e.getMessage());
		return new ResponseEntity<RestApiError>(restError, HttpStatus.BAD_REQUEST);
	}

}
