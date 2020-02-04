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
		int num = Integer.valueOf(request.getParameter("num"));
		ResultSet result = db.showAircraft(num);
		
		out.print("<form action='EditAircraft' method='post'>");
		out.print("<table class='show'>");
		out.print("<tr>");
		out.print("<td>");
		out.print("Aircraft Manufacturer");
		out.print("</td>");
		out.print("<td>");	
		out.print("Aircraft Number");
		out.print("</td>");
		out.print("</tr>");

		while (result.next()) {
			
			out.print("<tr>");
		
			out.print("<td>");
			out.print("<input type='text' name='aircraft_manu'  value= '"+ result.getString("aircraft_manu")+"'/>");
			session.setAttribute("oldmanu",result.getString("aircraft_manu"));
			out.print("</td>");
			out.print("<td>");
			out.print("<input type='text' name='aircraft_num' maxlength=3 value= '"+ result.getInt("aircraft_num")+"'/>");
			session.setAttribute("oldnum", result.getString("aircraft_num"));
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