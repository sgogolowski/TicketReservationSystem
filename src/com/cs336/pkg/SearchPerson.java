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

@WebServlet("/SearchPerson")
public class SearchPerson extends HttpServlet {
	
    public SearchPerson() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDB searchPerson = new ApplicationDB();
		

		ResultSet set = searchPerson.getCustomer();
		ArrayList<Person> personList = new ArrayList<>();
		
		
		
		HttpSession session = request.getSession();
		ArrayList<String> person = new ArrayList<>();
		
		session.setAttribute("person", person); 
			
		try {
			while(set.next()){
				Person inst = new Person(set.getString("username"),set.getString("password"),set.getString("fname"),set.getString("lname"), set.getString("email"), set.getString("isCustomerRep"),
						set.getString("isAdmin"));
				personList.add(inst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("personList", personList);
		request.getRequestDispatcher("adminDash.jsp").forward(request, response);
	}

}
