package com.ticketview.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ticketview.model.enums.Priority;
import com.ticketview.model.enums.Status;
import com.ticketview.model.enums.Type;

import lombok.Data;

@Data
public class TicketDetails {
	private String url;
	private int id;
	private String subject;
	private Priority priority;
	private Status status;
	
	@SerializedName("created_at")
	private String createdDate;
	
	private String description;
	
	@SerializedName("requester_id")
	private long requesterId;
	
	@SerializedName("assignee_id")
	private long AssigneId;
	
	@SerializedName("email_cc_ids")
	private List<String> emailsInCC;
	
	private Type type;
	
	
}
