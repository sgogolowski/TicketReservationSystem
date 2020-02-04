package com.cs336.pkg;

import java.util.ArrayList;

public class ReservationJ {
	private String ticket_number;
	private String flightNumber;
	private String airline_name;
	private String depart_time;
	private String depart_date;
	private String depart_airport_name;
	private String arrive_time;
	private String arrive_day;
	private String arrival_airport_name;
	private String meal_plan;
	private String reservation_number;
	private String seat_number;
	private String classType;
	private String totalSold;
	
	
	
	public String getticket_number() {
		return ticket_number;
	}

	public String gettotalSold() {
		return totalSold;
	}

	public String getflightNumber() {
		return flightNumber;
	}

	public String getairline_name() {
		return airline_name;
	}

	public String getdepart_time() {
		return depart_time;
	}

	
	public String getdepart_date() {
		return depart_date;
	}

	public String getdepart_airport_name() {
		return depart_airport_name;
	}

	public String getarrive_time() {
		return arrive_time;
	}

	public String getarrive_day() {
		return arrive_day;
	}

	public String getarrival_airport_name() {
		return arrival_airport_name;
	}

	public String getmeal_plan() {
		return meal_plan;
	}


	public String getreservation_number() {
		return reservation_number;
	}

	public String getseat_number() {
		return seat_number;
	}

	public String getclassType() {
		return classType;
	}

	public ReservationJ(String flightNumber, String airline_name, String totalSold) {
		this.flightNumber = flightNumber;
		this.airline_name = airline_name;
		this.totalSold = totalSold;
	}

	public ReservationJ(String ticket_number, String flightNumber, String airline_name, String depart_time, String depart_date, 
			String depart_airport_name, String arrive_time, String arrive_day, 
			String arrival_airport_name, String meal_plan, String reservation_number, String seat_number, String classType
			){
		this.ticket_number = ticket_number;
		this.flightNumber = flightNumber;
		this.airline_name = airline_name;
		this.depart_time = depart_time;
		this.depart_date = depart_date;
		this.depart_airport_name = depart_airport_name;
		this.arrive_time = arrive_time;
		this.arrive_day = arrive_day;
		this.arrival_airport_name = arrival_airport_name;
		this.meal_plan = meal_plan;
		this.reservation_number = reservation_number;
		this.seat_number = seat_number;
		this.classType = classType;

	}

	public void copyObject(ReservationJ reservation){
		this.ticket_number = reservation.getticket_number();
		this.flightNumber = reservation.getflightNumber();
		this.airline_name = reservation.getairline_name();
		this.depart_time = reservation.getdepart_time();
		this.depart_date = reservation.getdepart_date();
		this.depart_airport_name = reservation.getdepart_airport_name();
		this.arrive_time = reservation.getarrive_time();
		this.arrive_day = reservation.getarrive_day();
		this.arrival_airport_name = reservation.getarrival_airport_name();
		this.meal_plan = reservation.getmeal_plan();
		this.reservation_number = reservation.getreservation_number();
		this.seat_number = reservation.getseat_number();
		this.classType = reservation.getclassType();
		this.totalSold = reservation.gettotalSold();

	}
}
