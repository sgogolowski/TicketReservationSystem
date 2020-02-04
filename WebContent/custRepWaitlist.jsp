 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cs336.pkg.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Flight Wait List</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="./css/styles.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
    </head>
    <body>
    <button class="button" onclick="window.location.href = 'customer_rep_dash.jsp';">Dashboard</button><br/>
    <h1>Flight <%out.print(Integer.valueOf(request.getParameter("flightNumber"))); %> Wait List</h1>
	<%
	try {
		ApplicationDB db = new ApplicationDB();		
		int flightNum = Integer.valueOf(request.getParameter("flightNumber"));
		ResultSet result = db.getWaitList(flightNum);
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");
		out.print("<b>Passenger Username</b>");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
			
			out.print("<tr>");
		
			out.print("<td>");
			out.print(result.getString("username"));
			out.print("</td>");
			out.print("</tr>");

		}
		out.print("</table>");

		
	} catch (Exception e) {
		out.print(e);
	}
	%>
	
	<!-- <script src="" async defer></script> -->
    </body>
</html>