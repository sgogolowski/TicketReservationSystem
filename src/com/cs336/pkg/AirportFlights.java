package com.cs336.pkg;

import java.util.ArrayList;

public class AirportFlights {
	private String flightNumber;
	private String airline_name;
	private String depart_time;
	private String depart_date;
	private String depart_airport_name;
	private String arrive_time;
	private String arrive_date;
	private String arrival_airport_name;

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




	
	public String getArriveTime() {
		return arrive_time;
	}

	public void setArriveTime(String arriveTime) {
		this.arrive_time = arriveTime;
	}

	
	public String getDepartTime() {
		return depart_time;
	}

	public void setDepartTime(String departTime) {
		this.depart_time = departTime;
	}

	public AirportFlights(String flightNumber, String airline_name, String departTime, String arriveTime, String departAirport, String arriveAirport, String departDate, 
			String arriveDate){
		this.airline_name = airline_name;
		this.flightNumber = flightNumber;
		this.depart_time = departTime;
		this.arrive_time = arriveTime;
		this.depart_airport_name = departAirport;
		this.arrival_airport_name = arriveAirport;
		this.depart_date = departDate;
		this.arrive_date = arriveDate;
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
	
	public void copyObject(AirportFlights AirportFlights){
		this.airline_name = AirportFlights.getAirline_name();
		this.flightNumber = AirportFlights.getFlightNumber();
		this.depart_time = AirportFlights.getDepartTime();
		this.arrive_time = AirportFlights.getArriveTime();
		this.depart_airport_name = AirportFlights.getDepart_airport_name();
		this.arrival_airport_name = AirportFlights.getArrival_airport_name();
		this.depart_date = AirportFlights.getDepart_date();
		this.arrive_date = AirportFlights.getArrive_date();
	}
}
