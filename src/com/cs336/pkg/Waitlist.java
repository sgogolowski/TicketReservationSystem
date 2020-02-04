package com.cs336.pkg;

public class Waitlist {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
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
	public int getTravelers() {
		return travelers;
	}
	public void setTravelers(int travelers) {
		this.travelers = travelers;
	}
	public String getMeal_plan() {
		return meal_plan;
	}
	public void setMeal_plan(String meal_plan) {
		this.meal_plan = meal_plan;
	}
	private int flightNumber;
	private String airline_name;
	private String depart_airport_name;
	private String arrival_airport_name;
	private int travelers;
	private String meal_plan;
	public int getWaitlist_number() {
		return waitlist_number;
	}
	public void setWaitlist_number(int waitlist_number) {
		this.waitlist_number = waitlist_number;
	}
	private int waitlist_number;
	
	public Waitlist(int waitlist_number, String username, int flightNumber, String airline_name, String depart_airport_name, String arrival_airport_name, int travelers, String meal_plan){
		this.waitlist_number = waitlist_number;
		this.username = username;
		this.flightNumber = flightNumber;
		this.airline_name = airline_name;
		this.depart_airport_name = depart_airport_name;
		this.arrival_airport_name = arrival_airport_name;
		this.travelers = travelers;
		this.meal_plan = meal_plan;
	}
}
