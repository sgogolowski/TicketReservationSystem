<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/reservation.css">
<title>Reservation</title>
</head>
<body>
<div class="reserve">
	<h1>Confirm Reservations: ${username} </h1><br>
	<table cellspacing="13">
		<tr>
			<th>FLIGHT NUMBER</th>
			<th>AIRLINES</th>
			<th>DEPERTURE TIME</th>
			<th>DEPARTURE DATE</th>
			<th>DEPARTURE AIRPORT</th>
			<th>ARRIVAL TIME</th>
			<th>ARRIVAL DATE</th>
			<th>ARRIVAL AIRPORT</th>
		</tr>
		<c:forEach var="innerList" items="${list}">
		<tr>
			<c:forEach var="obj" items="${innerList}">
				<td style="text-align:center"><c:out value="${obj}"></c:out></td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table><br>

	<h3>Select Meal Plan:</h3>
	<form action="Reserve" method="post">
		<select name="meal_plan" class="choose">
			<option value="regular" selected>Regular</option>
			<option value="halal">Halal</option>
			<option value="veggie">Vegeterian</option>
		</select>
		<button class="book_button">BUY TICKET</button>
	</form><br>

	<form style="float: right;" method="Get" action="Logout">
		<input class="cancel_exit" type="submit" value="Logout" />
	</form>
	
	<form style="float: right;" method="Post" action="dashboard.jsp"> <!-- destroy the session before you go to dashboard -->
		<input class="cancel_exit" type="submit" value="Cancel" />
	</form>
	</div>
</body>
</html>