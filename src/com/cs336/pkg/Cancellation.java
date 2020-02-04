package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cancellation")
public class Cancellation extends HttpServlet {
	
    public Cancellation() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));
		int reservation_number = Integer.parseInt(request.getParameter("reservation_number"));
		String classType = request.getParameter("classType");
		ApplicationDB dao = new ApplicationDB();
		dao.updateAndDeleteTicket(flightNumber, classType, reservation_number);
		RequestDispatcher rd = request.getRequestDispatcher("ViewReservations");
		rd.forward(request,response);
	}
}
