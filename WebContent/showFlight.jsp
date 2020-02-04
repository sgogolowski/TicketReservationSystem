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
		int flightNum = Integer.valueOf(request.getParameter("flightNum"));
		ResultSet result = db.showFlight(flightNum);
		
		
		out.print("<form action='EditFlight' method='post'>");
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");
		out.print("Flight Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("Airline");
		out.print("</td>");
		out.print("<td>");
		out.print("First Class Price");
		out.print("</td>");
		out.print("<td>");	
		out.print("Economy Class Price");
		out.print("</td>");
		out.print("<td>");
		out.print("Business Class Price");
		out.print("</td>");
		out.print("<td>");	
		out.print("International");
		out.print("</td>");
		out.print("<td>");
		out.print("Depart Time");
		out.print("</td>");
		out.print("<td>");	
		out.print("Depart Date");
		out.print("</td>");
		out.print("<td>");
		out.print("Depart Airport");
		out.print("</td>");
		out.print("<td>");	
		out.print("Arrive Time");
		out.print("</td>");
		out.print("<td>");
		out.print("Arrive Date");
		out.print("</td>");
		out.print("<td>");	
		out.print("Arrive Airport");
		out.print("</td>");
		out.print("<td>");	
		out.print("Aircraft Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("First Class Seats");
		out.print("</td>");
		out.print("<td>");
		out.print("Business Class Seats");
		out.print("</td>");
		out.print("<td>");	
		out.print("Economy Class Seats");
		out.print("</td>");
		out.print("<td>");	
		out.print("Stops");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
		
			out.print("<tr>");
		
			out.print("<td>");
			out.print(result.getInt("flightNumber"));
			session.setAttribute("flightNum",result.getInt("flightNumber"));
			out.print("</td>");
			out.print("<td>");
			out.print(result.getString("airline_name"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='firstPrice' value= '"+ result.getInt("first_class_price")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='econPrice' value= '"+ result.getInt("economy_price")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='busPrice' value= '"+ result.getInt("business_price")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='international' value= '"+ result.getInt("isInternational")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='time' name='departTime' value= '"+ result.getTime("depart_time")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='date' name='departDate' value= '"+ result.getDate("depart_date")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print( result.getString("depart_airport_name"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='time' name='arriveTime' value= '"+ result.getTime("arrive_time")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='date' name='arriveDate' value= '"+ result.getDate("arrive_date")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print(result.getString("arrival_airport_name"));
			out.print("</td>");
			out.print("<td>");
			out.print(result.getInt("aircraft_num"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='firstSeats' value= '"+ result.getInt("first_class_capacity")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='busSeats' value= '"+ result.getInt("business_capacity")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='econSeats' value= '"+ result.getInt("economy_capacity")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='stops' value= '"+ result.getInt("stops")+"'/>");
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