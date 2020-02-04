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

@WebServlet("/SearchTickets")
public class SearchTickets extends HttpServlet {
	
    public SearchTickets() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchTicket = new ApplicationDB();
		
		String input = request.getParameter("saleReport");
		ResultSet set = searchTicket.getTicket(input);;
		
			
		ArrayList<Ticket> ticketList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> ticket = new ArrayList<>();
		
		session.setAttribute("ticket", ticket); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

			
		try {
			while(set.next()){
				Ticket inst = new Ticket(set.getString("ticket_number"),set.getString("username"), 
						set.getString("issue_date"),set.getString("price"));
				ticketList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ticketList", ticketList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
