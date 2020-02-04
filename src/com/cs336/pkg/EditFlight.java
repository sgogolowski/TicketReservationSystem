package com.cs336.pkg;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFlight
 */
public class EditFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlight() {
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
		int flightNum = Integer.valueOf(request.getSession(false).getAttribute("flightNum").toString());
		int firstPrice = Integer.valueOf(request.getParameter("firstPrice"));
		int econPrice = Integer.valueOf(request.getParameter("econPrice"));
		int busPrice = Integer.valueOf(request.getParameter("busPrice"));
		int international = Integer.valueOf(request.getParameter("international"));
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");
		String departDate = request.getParameter("departDate");
		String arriveDate = request.getParameter("arriveDate");
		int firstSeats = Integer.valueOf(request.getParameter("firstSeats"));
		int busSeats = Integer.valueOf(request.getParameter("busSeats"));
		int econSeats = Integer.valueOf(request.getParameter("econSeats"));
		int stops = Integer.valueOf(request.getParameter("stops"));
		ApplicationDB update = new ApplicationDB();
		update.updateFlight(flightNum,departTime,arriveTime,departDate,arriveDate,firstPrice,busPrice,econPrice,international,firstSeats,busSeats,econSeats,stops);
		response.sendRedirect("customer_rep_dash.jsp");
	}

}