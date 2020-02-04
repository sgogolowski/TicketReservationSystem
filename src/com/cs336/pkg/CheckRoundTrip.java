package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckRoundTrip")
public class CheckRoundTrip extends HttpServlet {
	
    public CheckRoundTrip() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String flightNumber = request.getParameter("flightNumber");
		int price = Integer.parseInt(request.getParameter("price"));
		int travelers = (Integer) session.getAttribute("travelers");
		ArrayList<String> flights = ((ArrayList<String>) session.getAttribute("flights"));
		int totalPrice =  (Integer) session.getAttribute("price");
		
		flights.add(flightNumber);
		totalPrice+=(travelers*price);
		
		boolean customerRep = (Boolean) session.getAttribute("customerRep");
		session.setAttribute("flights", flights);
		session.setAttribute("price", totalPrice);
		if((Boolean) session.getAttribute("roundTrip")==true){
			session.setAttribute("roundTrip", false);
			ResultSet set = null;
			ArrayList<Flight> list = new ArrayList<Flight>();
			
			ApplicationDB searchFlights = new ApplicationDB();
			String[] airport = (String[]) session.getAttribute("airport");
			Date[] date = (Date[])session.getAttribute("date");
			set = searchFlights.get2Flights(airport[1], airport[0], date[1], (String) session.getAttribute("class"));
			
			try {
				while(set.next()){
					Flight inst = new Flight(set.getString("flightNumber"),set.getString("airline_name"), set.getString("depart_time"), set.getString("arrive_time"),
							set.getString("depart_airport_name"), set.getString("arrival_airport_name"), set.getString("depart_date"), set.getString("arrive_date"), 
							set.getString("price"));
					list.add(inst);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			if(customerRep)
				request.getRequestDispatcher("makeCustReserv.jsp").forward(request, response);
			else
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else{
			
			ApplicationDB dao = new ApplicationDB();
			ArrayList<String> flightDetails = (ArrayList<String>) session.getAttribute("flights");
			for(int i=0; i<flightDetails.size(); i++){
				out.write(flightDetails.get(i));
			}
			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
			for(int i=0; i<flightDetails.size(); i++){
				ArrayList<String> col = new ArrayList<String>();
				ResultSet set = dao.getFlightDetails(flightDetails.get(i));
				try {
					while(set.next()){
						col.add(set.getString(1));
						col.add(set.getString(2));
						col.add(set.getString(7));
						col.add(set.getString(8));
						col.add(set.getString(9));
						col.add(set.getString(10));
						col.add(set.getString(11));
						col.add(set.getString(12));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				list.add(col);
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("reservation.jsp").forward(request, response);
		}
	}

}