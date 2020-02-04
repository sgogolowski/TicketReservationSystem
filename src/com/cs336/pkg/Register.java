package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
    public Register() {
       
    }
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String setUsername = (String) request.getParameter("setUsername");
		String setPassword = (String) request.getParameter("setPassword");
		String fname = (String) request.getParameter("firstName");
		String lname = (String) request.getParameter("lastName");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		String customerType = (String) request.getParameter("account");
		boolean isCustomerRep=false, isAdmin=false;
		if(customerType.equals("customer_rep"))
			isCustomerRep=true;
		else if(customerType.equals("Admin"))
			isAdmin=true;
	
		if(setPassword.length()>20 || setUsername.length()>20)
			response.sendRedirect("register.jsp");
		if(!setPassword.equals(confirmPassword))
			response.sendRedirect("register.jsp");
		
		ApplicationDB newUser = new ApplicationDB();
		try {
			newUser.register(setUsername,setPassword,fname,lname,isAdmin,isCustomerRep);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}