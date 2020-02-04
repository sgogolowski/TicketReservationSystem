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

@WebServlet("/SearchSummary")
public class SearchSummary extends HttpServlet {
	
    public SearchSummary() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchSummary = new ApplicationDB();
		
		String input = request.getParameter("summaryInput");
		ResultSet set = null;
		
		if(request.getParameter("summaryListOption").equals("flightNo")) {
			set = searchSummary.getSummary(input,"flightNo");
		}else if(request.getParameter("summaryListOption").equals("customerNa")) {
			set = searchSummary.getSummary(input,"customerNa");
		}else if(request.getParameter("summaryListOption").equals("airlineNo")) {
			set = searchSummary.getSummary(input,"airlineNo");
		}
		
		
			
		ArrayList<Summary> summaryList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> summary = new ArrayList<>();
		
		session.setAttribute("summary", summary); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

			
		try {
			while(set.next()){
				Summary inst = new Summary(set.getString("username"),set.getString("flightNumber"), 
						set.getString("airline_name"), set.getString("classType"), set.getString("economy_price"),
						set.getString("business_price"), set.getString("first_class_price"));
				summaryList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("summaryList", summaryList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
