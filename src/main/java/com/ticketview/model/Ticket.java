package com.ticketview.model;

import com.google.gson.annotations.SerializedName;
import com.ticketview.model.enums.Priority;
import com.ticketview.model.enums.Status;

import lombok.Data;


@Data
public class Ticket {
	
	private String url;
	private int id;
	private String subject;
	private Priority priority;
	private Status status;
	
	@SerializedName("created_at")
	private String createdDate;
	
	
}

