package com.cs336.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditReservation
 */
public class EditReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReservation() {
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
		int resNum = Integer.valueOf(request.getParameter("resnum"));
		String mealPlan = request.getParameter("mealPlan");
		int seatNum = Integer.valueOf(request.getParameter("seatNum"));
		String classType = request.getParameter("classType");
		ApplicationDB con = new ApplicationDB();
		HttpSession session = request.getSession();
		String oldclass =(String) session.getAttribute("oldclass");
		//check if seat is not taken
		con.updateReservation(resNum,mealPlan,classType,oldclass);
		response.sendRedirect("customer_rep_dash.jsp");
		
		
		
	}

}
