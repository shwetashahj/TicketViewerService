package com.ticketview.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ticketview.exception.ServerException;
import com.ticketview.response.ResponseWrapper;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ServerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseWrapper<Void> serverError(Exception ex) {
		ResponseWrapper<Void> errorResponse = new ResponseWrapper<>();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setSuccess(false);
		return errorResponse;
	}
	
	
}
