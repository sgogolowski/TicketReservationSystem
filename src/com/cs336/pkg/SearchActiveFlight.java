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

@WebServlet("/SearchActiveFlight")
public class SearchActiveFlight extends HttpServlet {
	
    public SearchActiveFlight() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchActiveFlight = new ApplicationDB();

		ResultSet set = searchActiveFlight.getActiveFlight();
		
			
		ArrayList<ReservationJ> activeFlightList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> activeFlight = new ArrayList<>();
		
		session.setAttribute("activeFlight", activeFlight); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

			
		try {
			while(set.next()){
				ReservationJ inst = new ReservationJ(set.getString("flightNumber"), set.getString("airline_name"),
						set.getString("count(flightNumber)"));
				activeFlightList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("activeFlightList", activeFlightList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
