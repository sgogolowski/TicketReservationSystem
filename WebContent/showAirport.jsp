 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Information</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="./css/styles.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
    </head>
    <body>
	<%
	try {
		ApplicationDB db = new ApplicationDB();		
		String airport = request.getParameter("airportID");
	
		ResultSet result = db.showAirport(airport);
		
		out.print("<form action='EditAirport' method='post'>");
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");
		out.print("Airport Name");
		out.print("</td>");
		out.print("<td>");
		out.print("Airport ID");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
			
			out.print("<tr>");
		
			out.print("<td>");
			out.print("<input type='text' name='airport_name' value= '"+ result.getString("airport_name")+"'/>");
			session.setAttribute("oldairportname",result.getString("airport_name"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='airport_id' value= '"+ result.getString("airport_id")+"'/>");
			session.setAttribute("oldairportid",result.getString("airport_id"));
			out.print("</td>");
			out.print("</tr>");

		}
		out.print("</table>");
		out.print("<button type='submit'>Save Changes</button>");
		out.print("</form>");
		out.print("<button onclick=\"window.location.href='customer_rep_dash.jsp';\">Cancel</button>");

		
	} catch (Exception e) {
		out.print(e);
	}
	%>
	
	<!-- <script src="" async defer></script> -->
    </body>
</html>