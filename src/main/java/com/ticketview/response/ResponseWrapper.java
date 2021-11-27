package com.ticketview.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Data 
@Getter
public class ResponseWrapper<T>{
	
	private T data;
	private String message;
	private boolean success;
	
}
