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

@WebServlet("/SearchAirportFlights")
public class SearchAirportFlights extends HttpServlet {
	
    public SearchAirportFlights() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchFlights = new ApplicationDB();
		String airportName = request.getParameter("airportName");
		

		ResultSet set = searchFlights.getFlightByAirport(airportName);
		ArrayList<AirportFlights> airportFlightList = new ArrayList<>();
		
		//String[] airport = {request.getParameter("departAirport"),request.getParameter("arriveAirport")};
		
		HttpSession session = request.getSession();
		ArrayList<String> airportFlight = new ArrayList<>();
		
		session.setAttribute("airportFlight", airportFlight); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

		
		try {
			while(set.next()){
				AirportFlights inst = new AirportFlights(set.getString("flightNumber"),set.getString("airline_name"), set.getString("depart_time"), set.getString("arrive_time"),
						set.getString("depart_airport_name"), set.getString("arrival_airport_name"), set.getString("depart_date"), set.getString("arrive_date")
						);
				airportFlightList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("airportFlightList", airportFlightList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
