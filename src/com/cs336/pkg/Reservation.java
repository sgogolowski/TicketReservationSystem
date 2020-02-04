package com.cs336.pkg;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
	private int ticket_number;
	public int getTicket_number() {
		return ticket_number;
	}
	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
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
	public int getReservation_number() {
		return reservation_number;
	}
	public void setReservation_number(int reservation_number) {
		this.reservation_number = reservation_number;
	}
	public String getMeal_plan() {
		return meal_plan;
	}
	public void setMeal_plan(String meal_plan) {
		this.meal_plan = meal_plan;
	}
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}
	private int flightNumber;
	private String airline_name;
	private String depart_airport_name;
	private String arrival_airport_name;
	private int reservation_number;
	private String meal_plan;
	private int seat_number; 
	private String classType;
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public Time getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(Time depart_time) {
		this.depart_time = depart_time;
	}
	public Time getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(Time arrive_time) {
		this.arrive_time = arrive_time;
	}
	public Date getDepart_date() {
		return depart_date;
	}
	public void setDepart_date(Date depart_date) {
		this.depart_date = depart_date;
	}
	public Date getArrive_date() {
		return arrive_date;
	}
	public void setArrive_date(Date arrive_date) {
		this.arrive_date = arrive_date;
	}
	private Time depart_time;
	private Time arrive_time;
	private Date depart_date;
	private Date arrive_date;
	
	
	public Reservation(int ticket_number, int flightNumber, String airline_name, String depart_airport_name, String arrival_airport_name, int reservation_number, String meal_plan, int seat_number, String classType, Time depart_time, Time arrive_time, Date depart_date, Date arrive_date){
		this.ticket_number = ticket_number;
		this.flightNumber = flightNumber;
		this.airline_name = airline_name;
		this.depart_airport_name = depart_airport_name;
		this.arrival_airport_name = arrival_airport_name;
		this.reservation_number = reservation_number;
		this.meal_plan = meal_plan;
		this.seat_number = seat_number;
		this.classType = classType;
		this.depart_time = depart_time;
		this.arrive_time = arrive_time;
		this.depart_date = depart_date;
		this.arrive_date = arrive_date;
	}
}