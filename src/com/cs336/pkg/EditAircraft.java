package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditAircraft
 */
public class EditAircraft extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAircraft() {
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
		String oldmanu = request.getSession(false).getAttribute("oldmanu").toString();
		int oldnum = Integer.valueOf(request.getSession(false).getAttribute("oldnum").toString());
		String newmanu = request.getParameter("aircraft_manu");
		int newnum = Integer.valueOf(request.getParameter("aircraft_num"));
		ApplicationDB update = new ApplicationDB();
		update.updateAircraft(oldmanu, oldnum,newmanu,newnum);
		response.sendRedirect("customer_rep_dash.jsp");
	}

}
