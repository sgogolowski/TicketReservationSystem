package com.cs336.pkg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MakeWaitlist")
public class MakeWaitlist extends HttpServlet {
	
    public MakeWaitlist() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("response");
		HttpSession session = request.getSession();
		boolean customerRep = (Boolean) session.getAttribute("customerRep");
		if(answer.equals("yes")){
			ApplicationDB dao = new ApplicationDB();
			String username = (String)session.getAttribute("username");
			ArrayList<String> flightNumbers = (ArrayList<String>) session.getAttribute("flights");
			int travelers = (Integer) session.getAttribute("travelers");
			String meal_plan = session.getAttribute("meal_plan").toString();
			try {
				dao.insertNewWaitlist(username, flightNumbers, travelers, meal_plan);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(customerRep)
			response.sendRedirect("makeCustReserv.jsp");
		else
			response.sendRedirect("dashboard.jsp");
	}

}