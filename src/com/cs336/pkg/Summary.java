package com.cs336.pkg;

import java.util.ArrayList;

public class Summary {
	private String username;
	private String flightNumber;
	private String airline_name;
	private String classType;
	private String economy_price;
	private String business_price;
	private String first_class_price;

	
	
	
	
	public String getusername() {
		return username;
	}

	public String getflightNumber() {
		return flightNumber;
	}

	public String getairline_name() {
		return airline_name;
	}

	public String getclassType() {
		return classType;
	}

	
	public String geteconomy_price() {
		return economy_price;
	}

	public String getbusiness_price() {
		return business_price;
	}

	public String getfirst_class_price() {
		return first_class_price;
	}

	

	public Summary(String username, String flightNumber, String airline_name, String classType, String economy_price, 
			String business_price, String first_class_price){
		this.username = username;
		this.flightNumber = flightNumber;
		this.airline_name = airline_name;
		this.classType = classType;
		this.economy_price = economy_price;
		this.business_price = business_price;
		this.first_class_price = first_class_price;

	}

	public void copyObject(Summary summary){
		this.username = summary.getusername();
		this.flightNumber = summary.getflightNumber();
		this.airline_name = summary.getairline_name();
		this.classType = summary.getclassType();
		this.economy_price = summary.geteconomy_price();
		this.business_price = summary.getbusiness_price();
		this.first_class_price = summary.getfirst_class_price();


	}
}
