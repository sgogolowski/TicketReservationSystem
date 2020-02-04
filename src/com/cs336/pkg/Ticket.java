package com.cs336.pkg;

import java.util.ArrayList;

public class Ticket {
	private String ticket_number;
	private String username;
	private String issue_date;
	private String price;

	
	
	
	
	public String getticket_number() {
		return ticket_number;
	}

	public String getusername() {
		return username;
	}

	public String getissue_date() {
		return issue_date;
	}

	public String getprice() {
		return price;
	}

	
	public Ticket( String username,String price
			){
		
		this.username = username;

		this.price = price;


	}
	public Ticket(String ticket_number, String username, String issue_date, String price
			){
		this.ticket_number = ticket_number;
		this.username = username;
		this.issue_date = issue_date;
		this.price = price;


	}

	public void copyObject(Ticket ticket){
		this.ticket_number = ticket.getticket_number();
		this.username = ticket.getusername();
		this.issue_date = ticket.getissue_date();
		this.price = ticket.getprice();


	}
}
