package com.ticketview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticketview.response.ResponseWrapper;

@SpringBootApplication
public class TicketViewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketViewServiceApplication.class, args);
		ResponseWrapper<String> res = new ResponseWrapper<>();
	}
	
	

}
