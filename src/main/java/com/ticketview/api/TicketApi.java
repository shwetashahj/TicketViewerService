package com.ticketview.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.ticketview.model.GetAllTicketResponse;
import com.ticketview.model.ShowTicketResponse;

public interface TicketApi{

	@GET("/api/v2/tickets")
	public Call<GetAllTicketResponse> getTickets(@Query("page") int page, @Query("per_page") int perPage);
	
	@GET("/api/v2/tickets/{id}")
	public Call<ShowTicketResponse> showTicket(@Path("id") int id);
	
}
