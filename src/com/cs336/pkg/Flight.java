package com.cs336.pkg;

import java.util.ArrayList;

public class Flight {
	private String flightNumber;
	private String airline_name;
	private String departTime;
	private String arriveTime;
	private String depart_airport_name;
	private String depart_date;
	public String getDepart_date() {
		return depart_date;
	}

	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}

	public String getArrive_date() {
		return arrive_date;
	}

	public void setArrive_date(String arrive_date) {
		this.arrive_date = arrive_date;
	}

	private String arrive_date;
	
	public String getDepart_airport_name() {
		return depart_airport_name;
	}

	public void setDepart_airport_name(String depart_airport_name) {
		this.depart_airport_name = depart_airport_name;
	}

	public String getArrival_airport_name() {
		return arrival_airport_name;
	}

	public void setArrival_airport_name(String arrival_airport_name) {
		this.arrival_airport_name = arrival_airport_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private String arrival_airport_name;
	private String price;
	
	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	
	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public Flight(String flightNumber, String airline_name, String departTime, String arriveTime, String departAirport, String arriveAirport, String departDate, 
			String arriveDate, String price){
		this.airline_name = airline_name;
		this.flightNumber = flightNumber;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.depart_airport_name = departAirport;
		this.arrival_airport_name = arriveAirport;
		this.depart_date = departDate;
		this.arrive_date = arriveDate;
		this.price = price;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	
	public void copyObject(Flight flight){
		this.airline_name = flight.getAirline_name();
		this.flightNumber = flight.getFlightNumber();
		this.departTime = flight.getDepartTime();
		this.arriveTime = flight.getArriveTime();
		this.depart_airport_name = flight.getDepart_airport_name();
		this.arrival_airport_name = flight.getArrival_airport_name();
		this.depart_date = flight.getDepart_date();
		this.arrive_date = flight.getArrive_date();
		this.price = flight.getPrice();
	}
}
