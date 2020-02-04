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

@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
	
    public EditCustomer() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB editCustomer = new ApplicationDB();
		
		String username = request.getParameter("personUsername");
		String password = request.getParameter("personPassword");
		String fname = request.getParameter("personFname");
		
		
		String lname = request.getParameter("personLname");
		
		String email = request.getParameter("personEmail");
		String isCustomerRep = request.getParameter("personIsCustomerRep");
		String isAdmin = request.getParameter("personIsAdmin");
		
		String inputType = request.getParameter("EditOption");
		
		editCustomer.editCustomer(username, password, fname, lname, email, isCustomerRep, isAdmin, inputType);

		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
