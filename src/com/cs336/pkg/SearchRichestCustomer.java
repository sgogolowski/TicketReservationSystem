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

@WebServlet("/SearchRichestCustomer")
public class SearchRichestCustomer extends HttpServlet {
	
    public SearchRichestCustomer() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchRich = new ApplicationDB();

		ResultSet set = searchRich.getRichestCustomer();
		
			
		ArrayList<Ticket> richList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> rich = new ArrayList<>();
		
		session.setAttribute("rich", rich); //session object flights contains reservations. reservations are added in CheckRoundTrip servlet

			
		try {
			while(set.next()){
				Ticket inst = new Ticket(set.getString("username"), 
						set.getString("sum(price)"));
				richList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("richList", richList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
