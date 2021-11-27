package com.ticketview.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticketview.model.GetAllTicketResponse;
import com.ticketview.model.ShowTicketResponse;
import com.ticketview.model.Ticket;
import com.ticketview.model.TicketDetails;
import com.ticketview.response.ResponseWrapper;
import com.ticketview.services.TicketService;

@RestController
public class TicketsController {

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = "/getTickets", method = RequestMethod.GET)
	public ResponseWrapper<GetAllTicketResponse> getAllTickets(HttpServletRequest request){
		
		return ticketService.getAllTickets();
		
	}
	
	@RequestMapping(value = "/showTicket/{id}", method = RequestMethod.GET)
	public ResponseWrapper<ShowTicketResponse> showTicket(HttpServletRequest request, @PathVariable(value= "id",required = true) int id){
		
		return ticketService.showTicket(id);
		
	}
	
}
