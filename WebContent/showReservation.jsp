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
		int resNum = Integer.valueOf(request.getParameter("resNum"));
		ResultSet result = db.showReservation(resNum);
		out.print("<h1>Reservation " + resNum + " </h1>");
		out.print("<form action='EditReservation' method='post'>");
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");	
		out.print("Reservation Number");
		out.print("</td>");
		out.print("<td>");
		out.print("Ticket Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("Flight Number");
		out.print("</td>");
		out.print("<td>");
		out.print("Airline Name");
		out.print("</td>");
		out.print("<td>");	
		out.print("Depart Time");
		out.print("</td>");
		out.print("<td>");
		out.print("Depart Date");
		out.print("</td>");
		out.print("<td>");	
		out.print("Departure Airport");
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
		out.print("Meal Plan");
		out.print("</td>");
		out.print("<td>");
		out.print("Seat Number");
		out.print("</td>");
		out.print("<td>");	
		out.print("Class Type");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
		
			out.print("<tr>");
		
			out.print("<td name='resnum'>");
			out.print("<input type='text' name='resnum' value='"+result.getInt("reservation_number")+"'/>");
			out.print("</td>");
			out.print("<td name='ticketNum'>");
			out.print(result.getInt("ticket_number"));
			out.print("</td>");
			out.print("<td name='flightNum'>");
			out.print(result.getInt("flightNumber"));
			out.print("</td>");
			out.print("<td name='airlineName'>");
			out.print(result.getString("airline_name"));
			out.print("</td>");
			out.print("<td name='departTime'>");
			out.print( result.getTime("depart_time"));
			out.print("</td>");
			out.print("<td name='departDate'>");
			out.print(result.getDate("depart_date"));
			out.print("</td>");
			out.print("<td name='departAirport'>");
			out.print(result.getString("depart_airport_name"));
			out.print("</td>");
			out.print("<td name='arriveTime'>");
			out.print(result.getTime("arrive_time"));
			out.print("</td>");
			out.print("<td name='arriveDate'>");
			out.print(result.getDate("arrive_day"));
			out.print("</td>");
			out.print("<td name='arriveAirport'>");
			out.print(result.getString("arrival_airport_name"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='mealPlan' value= '"+ result.getString("meal_plan")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='seatNum' value= '"+ result.getInt("seat_number")+"'/>");
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='classType' value= '"+ result.getString("classType")+"'/>");
			session.setAttribute("oldclass",result.getString("classType"));
			out.print("</td>");
		
			out.print("</tr>");

		}
		out.print("</table>");
		out.print("<button type='submit'>Save Changes</button>");
		out.print("</form>");
		

	} catch (Exception e) {
		out.print(e);
	}
	%>
	
	<!-- <script src="" async defer></script> -->
    </body>
</html>