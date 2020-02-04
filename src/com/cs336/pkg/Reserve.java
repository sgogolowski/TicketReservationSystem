package com.cs336.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	
    public Reserve() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ArrayList<String> flightNumbers = (ArrayList<String>) session.getAttribute("flights");
		int price = (Integer) session.getAttribute("price");
		String meal_plan = request.getParameter("meal_plan");
		boolean customerRep = (Boolean) session.getAttribute("customerRep");
		session.setAttribute("meal_plan", meal_plan);
		String username = (String) session.getAttribute("username");
		int travelers = (Integer) session.getAttribute("travelers");
		String classType = (String)session.getAttribute("classType");
		ApplicationDB dao = new ApplicationDB();
		try {
			if(dao.checkCapacity(flightNumbers, travelers, classType)){
				dao.insertNewReservation(username, price, meal_plan, flightNumbers, classType, travelers);
				if(customerRep)
					response.sendRedirect("makeCustReserv.jsp");	
				else
					response.sendRedirect("dashboard.jsp");
			}
			else{
				response.sendRedirect("waitlist.jsp");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}