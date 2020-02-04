package com.cs336.pkg;

import java.io.IOException;
import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFlight
 */
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String airline = request.getParameter("airline");
		String departAirport = request.getParameter("departAirport");
		String arriveAirport = request.getParameter("arriveAirport");
		Date departDate = Date.valueOf(request.getParameter("departDate"));
		Date arriveDate = Date.valueOf(request.getParameter("arriveDate"));
		String departTime = (request.getParameter("departTime"));
		String arriveTime = (request.getParameter("arriveTime"));
		int firstPrice = Integer.valueOf(request.getParameter("firstPrice"));
		int busPrice = Integer.valueOf(request.getParameter("busPrice"));
		int econPrice = Integer.valueOf(request.getParameter("econPrice"));
		int international = Integer.valueOf(request.getParameter("international"));
		int firstSeats= Integer.valueOf(request.getParameter("firstSeats"));
		int busSeats = Integer.valueOf(request.getParameter("busSeats"));
		int econSeats = Integer.valueOf(request.getParameter("econSeats"));
		int aircraftNum = Integer.valueOf(request.getParameter("aircraftNum"));
		int stops = Integer.valueOf(request.getParameter("stops"));
		
		ApplicationDB add = new ApplicationDB();
		
		add.insertFlight(airline, departAirport, arriveAirport, departDate, arriveDate, departTime, arriveTime, firstPrice, busPrice, econPrice, international,firstSeats, busSeats, econSeats,aircraftNum,stops);
		
		response.sendRedirect("customer_rep_dash.jsp");
		
		
		
		
	}

}
