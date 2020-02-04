package com.cs336.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditAirport
 */
public class EditAirport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAirport() {
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
		String oldairportname = request.getSession(false).getAttribute("oldairportname").toString();
		String oldairportid = request.getSession(false).getAttribute("oldairportid").toString();
		String newairportname = request.getParameter("airport_name");
		String newairportid = request.getParameter("airport_id");
		ApplicationDB update = new ApplicationDB();
		update.updateAirport(oldairportname, oldairportid ,newairportname,newairportid);
		response.sendRedirect("customer_rep_dash.jsp");
	}

}
