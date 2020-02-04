package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewReservations")
public class ViewReservations extends HttpServlet {
	
    public ViewReservations() {
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB dao = new ApplicationDB();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		ArrayList<Reservation> upcomingList = null;
		ArrayList<Reservation> pastList = null;
		ArrayList<Waitlist> waitList = null;
		try {
			upcomingList = dao.viewUpcomingReservations(username);
			pastList = dao.viewPastReservations(username);
			waitList = dao.viewWaitlist(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("upcomingReservations", upcomingList);
		request.setAttribute("pastReservations", pastList);
		request.setAttribute("waitlist", waitList);
		request.getRequestDispatcher("viewReservations.jsp").forward(request, response);
	}

}
