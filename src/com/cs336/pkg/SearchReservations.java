package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchReservation")
public class SearchReservations extends HttpServlet {
	
    public SearchReservations() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchResearvation = new ApplicationDB();
		
		String input = request.getParameter("searchRes");
		ResultSet set = null;
		
		if(request.getParameter("ListReservation").equals("flightNumber")) {
			set = searchResearvation.getReservation(input,"flightNumber");
		}else if(request.getParameter("ListReservation").equals("customerUsername")) {
			set = searchResearvation.getReservation(input,"customerUsername");
		}
		
		
			
		ArrayList<ReservationJ> reservationList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> reservation = new ArrayList<>();
		
		session.setAttribute("reservation", reservation); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

			
		try {
			while(set.next()){
				ReservationJ inst = new ReservationJ(set.getString("ticket_number"),set.getString("flightNumber"), 
						set.getString("airline_name"), set.getString("depart_time"), set.getString("depart_date"),
						set.getString("depart_airport_name"), set.getString("arrive_time"),
						set.getString("arrive_day"), set.getString("arrival_airport_name"), 
						set.getString("meal_plan"), set.getString("reservation_number"),
						set.getString("seat_number"), set.getString("classType"));
				reservationList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("reservationList", reservationList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
