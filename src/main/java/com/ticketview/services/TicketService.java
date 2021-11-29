package com.ticketview.services;

import com.ticketview.response.ResponseWrapper;

import retrofit2.Call;
import retrofit2.Response;

import org.springframework.stereotype.Service;

import com.ticketview.api.TicketApi;
import com.ticketview.api.ZendeskAPIClient;
import com.ticketview.exception.ServerException;
import com.ticketview.model.GetAllTicketResponse;
import com.ticketview.model.ShowTicketResponse;

@Service
public class TicketService {
	
	
	public ResponseWrapper<GetAllTicketResponse> getAllTickets(int page, int perPage) {
		
		ResponseWrapper<GetAllTicketResponse> wrapper = new ResponseWrapper<>();
	
		TicketApi ticketApi = ZendeskAPIClient.createService(TicketApi.class);
		Call<GetAllTicketResponse> callSync = ticketApi.getTickets(page, perPage);
		
		try {
			Response<GetAllTicketResponse> response = callSync.execute();
			wrapper.setData(response.body());
			wrapper.setSuccess(true);
		}catch(Exception ex) {
			wrapper.setMessage(ex.getMessage());
			throw new ServerException("Unable to get tickets list");
		}
		
		return wrapper;
	}
	
	public ResponseWrapper<ShowTicketResponse> showTicket(int id) {
		ResponseWrapper<ShowTicketResponse> wrapper = new ResponseWrapper<>();
		
		TicketApi ticketApi = ZendeskAPIClient.createService(TicketApi.class);
		Call<ShowTicketResponse> callSync = ticketApi.showTicket(id);
		
		try {
			Response<ShowTicketResponse> response = callSync.execute();
			wrapper.setData(response.body());
			wrapper.setSuccess(true);
		}catch(Exception ex) {
			wrapper.setMessage(ex.getMessage());
			throw new ServerException("Unable to get ticket's details");
		}
		
		return wrapper;
		
	}
}
