package com.cs336.pkg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.mysql.jdbc.Statement;

public class ApplicationDB {
	
	String url = "jdbc:mysql://cs336.c53p7gmkdybi.us-east-2.rds.amazonaws.com/cs336";
	String uname = "admin";
	String pass = "ihatecs123";
	Connection con;
	
	public ApplicationDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void register(String username, String password, String firstName, String lastName, boolean isAdmin, boolean isCustomerRep) throws ClassNotFoundException {
		String query = "INSERT INTO person (username,password,fname,lname,isCustomerRep,isAdmin) VALUES(?,?,?,?,?,?)"; //Making connection with the database 
		  try { 
			  PreparedStatement st = con.prepareStatement(query); 
			  st.setString(1,username);
		      st.setString(2, password);
		      st.setString(3, firstName);
		      st.setString(4, lastName);
		      st.setBoolean(5, isCustomerRep);
		      st.setBoolean(6, isAdmin);
		      st.executeUpdate(); 
		  	} 
		  catch(Exception e) {
			  e.printStackTrace(); 
		  }
	}
	
	public boolean login(String username, String password) throws ClassNotFoundException {
		String query = "SELECT * FROM person WHERE username = ? AND password = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet result = st.executeQuery();
			if(result.next())
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isCustomerRep(String username, String password){
		String query = "SELECT isCustomerRep FROM person WHERE username = ? AND password = ?";
		boolean isCustomerRep = false;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet result = st.executeQuery();
			if(result.next())
				isCustomerRep = result.getBoolean("isCustomerRep");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isCustomerRep;
	}
	
	public boolean isAdmin(String username, String password){
		String query = "SELECT isAdmin FROM person WHERE username = ? AND password = ?";
		boolean isAdmin = false;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet result = st.executeQuery();
			if(result.next())
				isAdmin = result.getBoolean("isAdmin");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isAdmin;
	}
	
	public ResultSet getFlights(String departAirport, String arriveAirport, Date departDate, String classType) throws ServletException{
		String query = "";
		if(classType.equals("business"))
			query = "SELECT flightNumber, airline_name, business_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE depart_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		else if(classType.equals("economy"))
			query = "SELECT flightNumber, airline_name, economy_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE depart_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		else
			query = "SELECT flightNumber, airline_name, first_class_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE depart_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setDate(1,departDate);
			st.setString(2,departAirport);
			st.setString(3,arriveAirport);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flights from DB", e);
		}
		return result;
	}
	
	public ResultSet get2Flights(String departAirport, String arriveAirport, Date arriveDate, String classType) throws ServletException{
		String query = "";
		if(classType.equals("business"))
			query = "SELECT flightNumber, airline_name, business_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE arrive_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		else if(classType.equals("economy"))
			query = "SELECT flightNumber, airline_name, economy_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE arrive_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		if(classType.equals("firstClass"))
			query = "SELECT flightNumber, airline_name, first_class_price AS 'price', depart_time, depart_date, depart_airport_name, arrive_time, arrive_date, arrival_airport_name FROM flight WHERE arrive_date = ? AND depart_airport_name = ? AND arrival_airport_name = ?";
		
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setDate(1,arriveDate);
			st.setString(2,departAirport);
			st.setString(3,arriveAirport);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flights from DB", e);
		}
		return result;
	}
	
	public ResultSet getFlightDetails(String flightNumber) throws ServletException{
		String query = "select * from flight where flightNumber = '" + flightNumber + "'";
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flight details from DB", e);
		}
		return result;
	}
	
	//insert a new ticket and return its unique number (pk) to be added to reservation table since reservation is the weak entity
	public int insertNewTicket(String username, int price) throws ServletException{
		String query = "SELECT MAX(ticket_number) FROM ticket";
		String query2 = "insert into ticket values(?,?,?,?)";
		ResultSet result = null;
		int id=0;
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
			
			if(result.last()){
				id=result.getInt("MAX(ticket_number)")+1;
			}
			PreparedStatement st2 = con.prepareStatement(query2);
			st2.setInt(1, id);
			st2.setString(2, username);
			st2.setDate(3, date);
			st2.setFloat(4, price);
			st2.executeUpdate();

		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flight details from DB", e);
		}
		return id;
	}
	
	//checks the capacity of requested classtype of the selected flight/s.
	public boolean checkCapacity(ArrayList<String> flights, int traveler, String classType) throws SQLException{
		String query="";
		int capacity=0;
		if(classType.equals("economy"))
			query = "select economy_capacity AS 'capacity' from flightCapacity where flightNumber=?";
		else if(classType.equals("business"))
			query = "select business_capacity AS 'capacity' from flightCapacity where flightNumber=?";
		else
			query = "select first_class_capacity AS 'capacity' from flightCapacity where flightNumber=?";
		ResultSet rs = null;
		for(int i=0; i<flights.size(); i++){
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Integer.parseInt(flights.get(i)));
			rs = st.executeQuery();
			while(rs.next()){
				capacity = rs.getInt("capacity");
			}
			if(traveler>capacity)
				return false;
		}
		return true;
	}
	
	public int getCapacity(String flightNumber, String classType){
		String query="";
		int capacity=0;
		if(classType.equals("economy"))
			query = "select economy_capacity AS 'capacity' from flightCapacity where flightNumber=?";
		else if(classType.equals("business"))
			query = "select business_capacity AS 'capacity' from flightCapacity where flightNumber=?";
		else
			query = "select first_class_capacity AS 'capacity' from flightCapacity where flightNumber=?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Integer.parseInt(flightNumber));
			ResultSet result = st.executeQuery();
			if (result.next())
				capacity = result.getInt("capacity");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return capacity;
	}
	
	public void updateCapacity(int capacity, String flightNumber, String classType){
		String query="";
		if(classType.equals("economy"))
			query = "update flightCapacity set economy_capacity = ? where flightNumber=?";
		else if(classType.equals("business"))
			query = "update flightCapacity set business_capacity = ? where flightNumber=?";
		else
			query = "update flightCapacity set first_class_capacity = ? where flightNumber=?";

		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, capacity);
			st.setInt(2, Integer.parseInt(flightNumber));
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertNewReservation(String username, int price, String meal_plan, ArrayList<String> flightNumbers, String classType, int travelers) throws ServletException, SQLException{
		//add seat number
		int ticket_number = insertNewTicket(username,price);
		String findNumberQuery = "SELECT MAX(reservation_number) FROM reservation";
		PreparedStatement st2 = con.prepareStatement(findNumberQuery);
		ResultSet numResult = st2.executeQuery();
		int reservation_number = 0;
		if(numResult.last()){
			reservation_number=numResult.getInt("MAX(reservation_number)")+1;
		}
		String query = "insert into reservation values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		ResultSet rs = null;
		try { 
				for(int i=0; i<flightNumbers.size(); i++){
					int capacity = getCapacity(flightNumbers.get(i), classType);
					for(int j=0; j<travelers; j++){
						PreparedStatement st = con.prepareStatement(query);
							rs = getFlightDetails(flightNumbers.get(i));
							while(rs.next()){
							  st.setInt(1,ticket_number);
							  st.setInt(2,rs.getInt("flightNumber"));
							  st.setString(3,rs.getString("airline_name"));
							  st.setTime(4,rs.getTime("depart_time"));
							  st.setDate(5,rs.getDate("depart_date"));
							  st.setString(6,rs.getString("depart_airport_name"));
							  st.setTime(7,rs.getTime("arrive_time"));
							  st.setDate(8,rs.getDate("arrive_date"));
							  st.setString(9,rs.getString("arrival_airport_name"));
							  st.setString(10,meal_plan);
							  st.setInt(11, reservation_number);
							  st.setInt(12, capacity);
							  st.setString(13, classType);
							  reservation_number+=1;
						      st.executeUpdate();
							}
							capacity-=1;
					}
					updateCapacity(capacity,flightNumbers.get(i),classType);
				} 
		  	} 
		  catch(Exception e) {
			  e.printStackTrace(); 
		  }
	}
	
	public void insertNewWaitlist(String username, ArrayList<String> flightNumbers, int travelers, String meal_plan) throws ServletException, SQLException{
		String findNumberQuery = "SELECT MAX(waitlist_number) FROM waitlist";
		PreparedStatement st2 = con.prepareStatement(findNumberQuery);
		ResultSet numResult = st2.executeQuery();
		int waitlist_number = 0;
		if(numResult.last()){
			waitlist_number=numResult.getInt("MAX(waitlist_number)")+1;
		}
		
		for(int i=0; i<flightNumbers.size(); i++){
				String query = "insert into waitlist values(?,?,?,?,?,?,?,?)";
				ResultSet rs = getFlightDetails(flightNumbers.get(i));
				PreparedStatement st = con.prepareStatement(query);
				while(rs.next()){
					st.setString(1, username);
					st.setInt(2, rs.getInt("flightNumber"));
					st.setString(3, rs.getString("airline_name"));
					st.setString(4, rs.getString("arrival_airport_name"));
					st.setString(5, rs.getString("depart_airport_name"));
					st.setInt(6, travelers);
					st.setString(7, meal_plan);	
					st.setInt(8, waitlist_number);	
					st.executeUpdate();
					waitlist_number+=1;
				}
		}
	}
	
	public ArrayList<Reservation> viewUpcomingReservations(String username) throws SQLException{
		ResultSet rs = null;
		ArrayList<Reservation> list = new ArrayList<>();
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
		String query = "select * from ticket, reservation where ticket.ticket_number = reservation.ticket_number and ticket.username=? and reservation.depart_date >= ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setDate(2, date);
		rs = st.executeQuery();
		while(rs.next()){
			Reservation r = new Reservation(rs.getInt("ticket_number"), rs.getInt("flightNumber"), rs.getString("airline_name"), rs.getString("depart_airport_name"), rs.getString("arrival_airport_name"), rs.getInt("reservation_number"), rs.getString("meal_plan"), rs.getInt("seat_number"), rs.getString("classType"), rs.getTime("depart_time"), rs.getTime("arrive_time"), rs.getDate("depart_date"), rs.getDate("arrive_day"));
			list.add(r);
		}
		return list;
	}
	
	public ArrayList<Reservation> viewPastReservations(String username) throws SQLException{
		ResultSet rs = null;
		ArrayList<Reservation> list = new ArrayList<>();
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
		String query = "select * from ticket, reservation where ticket.ticket_number = reservation.ticket_number and ticket.username=? and reservation.depart_date < ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setDate(2, date);
		rs = st.executeQuery();
		while(rs.next()){
			Reservation r = new Reservation(rs.getInt("ticket_number"), rs.getInt("flightNumber"), rs.getString("airline_name"), rs.getString("depart_airport_name"), rs.getString("arrival_airport_name"), rs.getInt("reservation_number"), rs.getString("meal_plan"), rs.getInt("seat_number"), rs.getString("classType"), rs.getTime("depart_time"), rs.getTime("arrive_time"), rs.getDate("depart_date"), rs.getDate("arrive_day"));
			list.add(r);
		}
		return list;
	}
	
	public ArrayList<Waitlist> viewWaitlist(String username) throws SQLException{
		ResultSet rs = null;
		ArrayList<Waitlist> list = new ArrayList<>(); 
		String query = "select * from waitlist where username = ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		rs = st.executeQuery();
		while(rs.next()){
			Waitlist w = new Waitlist(rs.getInt("waitlist_number"), rs.getString("username"), rs.getInt("flightNumber"), rs.getString("airline_name"), rs.getString("depart_airport_name"), rs.getString("arrival_airport_name"), rs.getInt("travelers"),rs.getString("meal_plan"));
			list.add(w);
		}
		return list;
	}
	
	public int getFlightPrice(int flightNumber, String classType){ //gets the price of the flight according to flightNumber and classType
		String query = "";
		ResultSet rs=null;
		int price=0;
		if(classType.equals("business"))
			query = "SELECT business_price AS 'price' FROM flight WHERE flightNumber = ?";
		else
			query = "SELECT first_class_price AS 'price' FROM flight WHERE flightNumber = ?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNumber);
			rs = st.executeQuery();
			while(rs.next()){
				price = rs.getInt("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	public void deleteTicket(){
		String query = "delete from ticket where price=?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, 0);
			st.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateTicketPrice(int flightNumber, String classType, int totalPrice, int ticket_number){
		int price = getFlightPrice(flightNumber,classType);
		int updatedPrice = totalPrice - price;
		String query3 = "update ticket set price = ? where ticket_number = ?";
		try{
			PreparedStatement st3 = con.prepareStatement(query3);
			st3.setInt(1, updatedPrice);
			st3.setInt(2, ticket_number);
			st3.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateAndDeleteTicket(int flightNumber, String classType, int reservation_number){
		String query = "select ticket_number, price from ticket where ticket_number = (select ticket_number from reservation where reservation_number=?)";
		ResultSet rs = null;
		int totalPrice=0, ticket_number=0;
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, reservation_number);
			rs = st.executeQuery();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {				
				if (rs.next() == false) {
					throw new Exception("resultset is emtpty");
				} else {
					do {
						ticket_number = (rs.getInt("ticket_number"));
						totalPrice = (rs.getInt("price"));
					} while (rs.next());
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		updateTicketPrice(flightNumber, classType, totalPrice, ticket_number);
		
		deleteTicket();
		
		deleteReservation(flightNumber, classType, reservation_number);
		
		updateFlightCapacity(flightNumber, classType);
		
	}
	
	public void deleteReservation(int flightNumber, String classType, int reservation_number){ //delete reservation based on reservation_number
		
		//-----------------------Delete the reservation
		String query = "delete from reservation where reservation_number=?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, reservation_number);
			st.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void updateFlightCapacity(int flightNumber, String classType){
		String query = "";
		if(classType.equals("business"))
			query = "update flightCapacity set business_capacity = business_capacity+1 where flightNumber=?";
		else
			query = "update flightCapacity set first_class_capacity = first_class_capacity+1 WHERE flightNumber = ?"; 
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setInt(1, flightNumber);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	//----------------------Jianyu-------------------------
	public ResultSet getCustomer() throws ServletException{
		String query = "select * from person";
		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain customer details from DB", e);
		}
		return result;
	}
	
	public ResultSet getReservation(String input, String inputType) throws ServletException{
		String query = "";
		if(inputType.equals("flightNumber")) {
			query = "select * from reservation where flightNumber = '" + input + "'";
		}else if (inputType.equals("customerUsername")) {
			query = "select * from reservation where ticket_number in (select ticket_number from ticket where username = '"+ input +"')";
		}

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain reservation details from DB", e);
		}
		return result;
	}
	public ResultSet getTicket(String input) throws ServletException{
		
		String year = input.subSequence(0, 4).toString();
		String month = input.subSequence(5, 7).toString();
		
		String query = "select * from ticket where extract(year from issue_date) = '"+ year +"' AND extract(month from issue_date) = '"+ month +"'";
		

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain tickets details from DB", e);
		}
		return result;
	}
	
	public ResultSet getFlightByAirport(String airport) throws ServletException{
		
		
		String query = "select * from flight where depart_airport_name = '" + airport + "' or arrival_airport_name = '" + airport + "'";
		

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain flights details from DB", e);
		}
		return result;
	}
	public ResultSet getSummary(String input, String inputType) throws ServletException{
		String query = "";
		if(inputType.equals("flightNo")) {
			query = "select ticket.username, reservation.flightNumber,reservation.airline_name,reservation.classType, flight.economy_price, flight.business_price, flight.first_class_price from reservation join flight on reservation.flightNumber = flight.flightNumber join ticket on reservation.ticket_number = ticket.ticket_number where reservation.flightNumber = '" + input +"'";
		}else if (inputType.equals("customerNa")) {
			query = "select ticket.username, reservation.flightNumber,reservation.airline_name,reservation.classType, flight.economy_price, flight.business_price, flight.first_class_price from reservation join flight on reservation.flightNumber = flight.flightNumber join ticket on reservation.ticket_number = ticket.ticket_number where ticket.username = '" + input +"'";
		}else if(inputType.equals("airlineNo")) {
			query = "select ticket.username, reservation.flightNumber,reservation.airline_name,reservation.classType, flight.economy_price, flight.business_price, flight.first_class_price from reservation join flight on reservation.flightNumber = flight.flightNumber join ticket on reservation.ticket_number = ticket.ticket_number where reservation.airline_name = '" + input +"'";
		}

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain Summary details from DB", e);
		}
		return result;
	}
	public ResultSet getRichestCustomer() throws ServletException{
		String query = "select username, sum(price) from ticket group by username order by price DESC";

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain Customer details from DB", e);
		}
		return result;
	}
	public ResultSet getActiveFlight() throws ServletException{
		String query = "select flightNumber,airline_name,count(flightNumber) from reservation group by flightNumber order by count(flightNumber) DESC";

		ResultSet result = null;
		try {
			PreparedStatement st = con.prepareStatement(query);
			result = st.executeQuery();
		}
		catch(Exception e) {
			throw new ServletException("Cannot obtain Active Flight details from DB", e);
		}
		return result;
	}
	public void editCustomer(String username, String password, String fname, String lname, String email, String isCustomerRep,String isAdmin, String inputType) throws ServletException{
		String query = "";
		
		if(inputType.equals("Add")) {
			query = "insert into person\r\n" + 
					"values ('"+ username +"','"+password+"','"+fname+"','"+lname+"','"+email+"','"+isCustomerRep+"','"+isAdmin+"');";
		}else if(inputType.equals("Edit")) {
			query = "UPDATE person\r\n" + 
					"SET password = '"+password+"', fname = '"+fname+"', lname = '"+lname+"',email = '"+email+"', isCustomerRep = '"+isCustomerRep+"', isAdmin = '"+isAdmin+"'\r\n" + 
					"WHERE username = '"+username+"';";
		}else if(inputType.equals("Delete")) {
			query = "delete from person where username = '"+username+"'";
		}
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate();
			
		}
		catch(Exception e) {
			throw new ServletException("Cannot Edit Customer in DB", e);
		}
		
	}
	
	public void insertFlight(String airline,String departAirport, String arriveAirport, Date departDate, Date arriveDate, String departTime, String arriveTime, int firstPrice, int busPrice, int econPrice, int international, int firstSeats, int busSeats, int econSeats, int aircraftNum, int stops) throws ServletException{
		String query = "SELECT flightNumber FROM flight GROUP BY flightNumber";
		int id=0;
		try{
		PreparedStatement st = con.prepareStatement(query);
		ResultSet set = st.executeQuery();
		if(set.last())
			id = set.getInt("flightNumber") + 1;
		String insertQeury = "INSERT INTO flight VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		st = con.prepareStatement(insertQeury);
		st.setInt(1, id);
		st.setString(2,airline);
		st.setInt(3,firstPrice);
		st.setInt(4,busPrice);
		st.setInt(5,econPrice);
		st.setInt(6, international);
		st.setString(7,(departTime));
		st.setDate(8, departDate);
		st.setString(9,departAirport);
		st.setString(10,(arriveTime));
		st.setDate(11, arriveDate);
		st.setString(12, arriveAirport);
		st.setInt(13, aircraftNum);
		st.setInt(14, stops);
		st.execute();
		String insert2 = "INSERT INTO flightCapacity VALUES(?,?,?,?,?,?,?)";
		st = con.prepareStatement(insert2);
		st.setInt(1, id);
		st.setString(2,airline);
		st.setString(3, departAirport);
		st.setString(4, arriveAirport);
		st.setInt(5,econSeats);
		st.setInt(6,firstSeats);
		st.setInt(7,busSeats);
		st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot insert flight into DB",e);
		}
	}
	
	public void insertAircraft(String manu, int num) throws ServletException{
		String query="INSERT INTO aircraft VALUES (?,?)";
		
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			st.setString(2, manu);
			st.execute();
			}
		catch(Exception e){
			throw new ServletException("Cannot insert aircraft into DB",e);
		}
	}
	public void insertAirport(String airportName, String id) throws ServletException{
		String query="INSERT INTO airport VALUES (?,?)";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,airportName);
			st.setString(2,id);
			st.execute();
			}
		catch(Exception e){
			throw new ServletException("Cannot insert aircraft into DB",e);
		}
	}
	
	public void deleteFlight(int flightNum) throws ServletException{
		String findReservation = "select reservation_number from reservation where flightNumber=?";
		int resNum=0;
		String query="SELECT ticket_number, price FROM ticket WHERE ticket_number = (select ticket_number from reservation where reservation_number = ?)";
		String query1="DELETE FROM ticket where ticket_number = ?";
		String query2 ="DELETE FROM flightCapacity WHERE flightNumber = ?";
		String query3="DELETE FROM waitlist WHERE flightNumber = ?";
		String query4="DELETE FROM flight WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(findReservation);
			st.setInt(1, flightNum);
			ResultSet set = st.executeQuery();
			if(set.next())
				resNum = set.getInt("reservation_number");
			st=con.prepareStatement(query);
			st.setInt(1,resNum);
			set = st.executeQuery();
			int ticket=0;
			if(set.next())
				ticket = set.getInt("ticket_number");
			
			
			st = con.prepareStatement(query1);
			st.setInt(1, ticket);
			st.execute();
			st = con.prepareStatement(query2);
			st.setInt(1, flightNum);
			st.execute();
			st = con.prepareStatement(query3);
			st.setInt(1,flightNum);
			st.execute();
			st = con.prepareStatement(query4);
			st.setInt(1,flightNum);
			st.execute();
					
		}
		catch(Exception e){
			throw new ServletException("Cannot delete flight from DB",e);
		}
	}
	
	public void deleteAircraft(int num) throws ServletException{
		String query="DELETE FROM aircraft WHERE aircraft_num = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot delete aircraft from DB",e);
		}
		
	}
	
	public void deleteAirport(String name) throws ServletException{
		String query="DELETE FROM airport WHERE airport_name = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("Cannot delete airport from DB",e);
		}
	}
	
	public ResultSet showFlight(int flightNum) throws ServletException{
		String query="SELECT * from flight INNER JOIN flightCapacity USING(flightNumber) WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNum);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that flight in DB",e);
		}
	}
	public ResultSet showAircraft(int num) throws ServletException{
		String query="SELECT * from aircraft WHERE aircraft_num = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, num);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that aircraft in DB",e);
		}
	}
	public ResultSet showAirport(String id) throws ServletException{
		String query="SELECT * from airport WHERE airport_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			ResultSet set=st.executeQuery();
			return set;
		}
		catch(Exception e){
			throw new ServletException("Cannot find that airport in DB",e);
		}
	}
	public void updateFlight(int flightNum, String departTime, String arriveTime,String departDate,String arriveDate, int firstPrice, int busPrice, int econPrice, int international, int firstSeats, int busSeats, int econSeats, int stops) throws ServletException{
		String query="UPDATE flight SET first_class_price = ?, economy_price = ?, business_price = ?, isInternational = ?, "
				+ "depart_time = ?, arrive_time = ?, depart_date = ?, arrive_date = ? , "
				+ " stops = ? WHERE flightNumber = ?";
		String query2= "UPDATE flightCapacity SET first_class_capacity = ?, business_capacity = ?, economy_capacity = ? WHERE flightNumber = ?";
		String query3= "UPDATE reservation SET arrive_time = ?, depart_time = ?, depart_date = ? , arrive_day = ? WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,firstPrice);
			st.setInt(2, econPrice);
			st.setInt(3, busPrice);
			st.setInt(4, international);
			st.setString(5, departTime);	
			st.setString(6,arriveTime);
			st.setString(7,departDate);
			st.setString(8,arriveDate);
			st.setInt(9,stops);
			st.setInt(10, flightNum);
			st.executeUpdate();
			st = con.prepareStatement(query2);
			st.setInt(1, firstSeats);
			st.setInt(2, busSeats);
			st.setInt(3, econSeats);
			st.setInt(4,flightNum);
			st.executeUpdate();
			st=con.prepareStatement(query3);
			st.setString(1, arriveTime);
			st.setString(2,departTime);
			st.setString(3, departDate);
			st.setString(4,arriveDate);
			st.setInt(5, flightNum);
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public void updateAircraft(String oldmanu,int oldnum, String newmanu, int newnum) throws ServletException{
		String query="UPDATE aircraft SET aircraft_manu = ?, aircraft_num = ? WHERE"
				+ " aircraft_manu = ? AND aircraft_num = ? ";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, newmanu);
			st.setInt(2,newnum);
			st.setString(3, oldmanu);
			st.setInt(4,oldnum);
			
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public void updateAirport(String oldAirportName, String oldAirportID, String newAirportName, String newAirportID) throws ServletException{
		String query="UPDATE airport SET airport_name = ?,airport_id=?  WHERE"
				+ " airport_name = ? AND airport_id = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, newAirportName);
			st.setString(2, newAirportID);
			st.setString(3,oldAirportName);
			st.setString(4,oldAirportID);
			
			st.executeUpdate();
		}
		catch(Exception e){
			throw new ServletException("unable to save changes to flight",e);
		}
	}
	public ResultSet getWaitList(int flightNumber) throws ServletException{
		String query = "SELECT * FROM waitlist WHERE flightNumber = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, flightNumber);
			ResultSet result = st.executeQuery();
			return result;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch waitlist", e);
		}
	}
	public ResultSet showReservation(int resNum) throws ServletException{
		String query = "SELECT * FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, resNum);
			ResultSet result = st.executeQuery();
			return result;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch reservation" , e);
		}
	}
	public boolean validSeatNum(int resNum, int seatNum) throws ServletException{
		String query="SELECT reservation_number FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, resNum);
			ResultSet set = st.executeQuery();
			int seat;
			while(set.next())
				if((seat = set.getInt("reservation_number")) == seatNum)
					return false;
			return true;
		}
		catch(Exception e){
			throw new ServletException("unable to fetch reservation", e);
		}
		
	}
	public void updateReservation(int resNum, String mealPlan, String newclassType, String oldclassType) throws ServletException{
		String query="UPDATE reservation SET meal_plan = ?, classType = ? WHERE reservation_number = ?";
		String query2="SELECT * FROM reservation WHERE reservation_number = ? ";
		try{
		
			PreparedStatement st=con.prepareStatement(query2);
			st.setInt(1,resNum);
			ResultSet set = st.executeQuery();
			if(set.next()){
				int flightNum = set.getInt("flightNumber");
				int ticketNum = set.getInt("ticket_number");
			
				String query3="SELECT price FROM ticket WHERE ticket_number = ?";
				st=con.prepareStatement(query3);
				st.setInt(1, ticketNum);
				set=st.executeQuery();
				if(set.next()){
					int oldPrice=set.getInt("price");
					
				String query4;
				if(oldclassType.equals("economy")){
					query4 = "SELECT economy_price AS 'price' FROM flight WHERE flightNumber = ?";
					
				}
				else if(oldclassType.equals("business")){
					query4 = "SELECT business_price AS 'price' FROM flight WHERE flightNumber = ?";
				}
				else{
					query4 = "SELECT first_class_price AS 'price' FROM flight WHERE flightNumber = ?";
				}
				st=con.prepareStatement(query4);
				st.setInt(1,flightNum);
				set = st.executeQuery();
				int oldClassPrice=0;
				if(set.next())
					oldClassPrice=set.getInt("price");
				
				if(newclassType.equals("economy")){
					query4 = "SELECT economy_price AS 'price' FROM flight WHERE flightNumber = ?";
					
				}
				else if(newclassType.equals("business")){
					query4 = "SELECT business_price AS 'price' FROM flight WHERE flightNumber = ?";
				}
				else{
					query4 = "SELECT first_class_price AS 'price' FROM flight WHERE flightNumber = ?";
				}
				st=con.prepareStatement(query4);
				st.setInt(1,flightNum);
				set = st.executeQuery();
				int newPrice=0;
				if(set.next())
					newPrice=set.getInt("price");
					
				String updateTicketPrice = "UPDATE ticket SET price = ? where ticket_number = ?";
				st= con.prepareStatement(updateTicketPrice);
				st.setInt(1, oldPrice - oldClassPrice + newPrice);
				st.setInt(2, ticketNum);
				st.executeUpdate();
				
				st = con.prepareStatement(query);
				st.setString(1, mealPlan);
				st.setString(2, newclassType);
				st.setInt(3,resNum);
				st.executeUpdate();
				
				}
			}
			
			
		}
		catch(Exception e){
			throw new ServletException("unable to update reservation" , e);
		}
	}
	public void deleteReservation(int resNum) throws ServletException{
		String query = "DELETE FROM reservation WHERE reservation_number = ?";
		try{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,resNum);
			st.execute();
		}
		catch(Exception e){
			throw new ServletException("unable to delete reservation",e );
		}
	}
}
