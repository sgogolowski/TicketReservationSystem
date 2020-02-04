package com.cs336.pkg;

import java.util.ArrayList;

public class Person {
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private String isCustomerRep;
	private String isAdmin;
	public String getfname() {
		return fname;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setfname(String fname) {
		this.fname = fname;
	}

	public String getlname() {
		return lname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}

	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getisCustomerRep() {
		return isCustomerRep;
	}

	public void setisCustomerRep(String isCustomerRep) {
		this.isCustomerRep = isCustomerRep;
	}

	public String getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}



	public Person(String username,String password, String fname, String lname, String email, String isCustomerRep, String isAdmin 
			){
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.isCustomerRep = isCustomerRep;
		this.isAdmin = isAdmin;

	}

	public void copyObject(Person person){
		this.username = person.getUsername();
		this.password = person.getPassword();
		this.fname = person.getfname();
		this.lname = person.getlname();
		this.email = person.getemail();
		this.isCustomerRep = person.getisCustomerRep();
		this.isAdmin = person.getisAdmin();

	}
}
