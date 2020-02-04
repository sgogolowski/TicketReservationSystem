package com.cs336.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFlight
 */
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlight() {
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
		int flightNum = Integer.valueOf(request.getParameter("flightNum"));
		int confirm = Integer.valueOf(request.getParameter("confirm"));
		ApplicationDB delete = new ApplicationDB();
		if(confirm==1){
			delete.deleteFlight(flightNum);
			response.sendRedirect("customer_rep_dash.jsp");
		}
		else
			response.sendRedirect("deleteInfo.jsp");
	}
	}


