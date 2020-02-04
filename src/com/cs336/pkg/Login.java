package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
    public Login() {
        
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ApplicationDB loginUser = new ApplicationDB();
		try {
			if(loginUser.login(username, password)==true){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				if(loginUser.isCustomerRep(username, password)){
					response.sendRedirect("customer_rep_dash.jsp");
					session.setAttribute("customerRep", true);
				}
				else if(loginUser.isAdmin(username, password)){
					response.sendRedirect("adminDash.jsp");
					session.setAttribute("customerRep", false);
				}
				else{
					session.setAttribute("customerRep", false);
					response.sendRedirect("dashboard.jsp");
				}
					
			}
			else
				response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
