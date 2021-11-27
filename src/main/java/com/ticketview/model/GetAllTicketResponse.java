package com.ticketview.model;

import lombok.Data;
import java.util.*;

@Data
public class GetAllTicketResponse {
	List<Ticket> tickets;
}
