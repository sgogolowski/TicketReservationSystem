<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/viewReservation.css">
<link rel="stylesheet" href="./css/customer_style.css">
<title>View Reservation</title>
</head>
<body>

	<div class="topnav">
            <h1 style="float: left; margin-left: 20px;">Travel Website - <i><small>${username}</small></i></h1>
            <div class="topnav-right">
            	<a href="">REservations</a>
            	
                <img src="./img/user.png" style="width: 70px; height: 70px; padding: 10px; margin: 10px;">
            </div>
      </div>
      
      <div class="alert">
  			<center><b>Important Note:</b> You can only cancel business or first-class reservations. Economy reservations are not refundable</center>
		</div>
          
	<br>
	
	<div class="cardView">
	
	<h1>Upcoming Reservations for ${username}</h1>
	
		<table>
			<thead>
				<tr style="font-weight:bold;">
					<td>TICKET NUMBER</td>
					<td>FLIGHT NUMBER</td>
					<td>AIRLINES</td>
					<td>DEPARTURE AIRPORT</td>
					<td>DEPARTURE DATE</td>
					<td>DEPARTURE TIME</td>
					<td>ARRIVAL AIRPORT</td>
					<td>ARRIVAL DATE</td>
					<td>ARRIVAL TIME</td>
					<td>RESERVATION NUMBER</td>
					<td>MEAL PLAN</td>
					<td>CLASS TYPE</td>
					<td>OPTION</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${upcomingReservations}" var="reserve">
					<tr>
						<td align="left">${reserve.ticket_number}</td>
						<td align="left">${reserve.flightNumber}</td>
						<td align="left">${reserve.airline_name}</td>
						<td align="left">${reserve.depart_airport_name}</td>
						<td align="left">${reserve.depart_date}</td>
						<td align="left">${reserve.depart_time}</td>
						<td align="left">${reserve.arrival_airport_name}</td>
						<td align="left">${reserve.arrive_date}</td>
						<td align="left">${reserve.arrive_time}</td>
						<td align="left">${reserve.reservation_number}</td>
						<td align="left">${reserve.meal_plan}</td>
						<td align="left">${reserve.classType}</td>
						<c:choose>
							<c:when test="${(reserve.classType).equals('business') || (reserve.classType).equals('firstClass')}">
								<td><a
									href="${pageContext.request.contextPath}/Cancellation?reservation_number=${reserve.reservation_number}&flightNumber=${reserve.flightNumber}&classType=${reserve.classType}">CANCEL</a></td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>

	<div class="cardView">
	
	<h1>Past Reservations for ${username}</h1>
	
		<table>
			<thead>
				<tr style="font-weight:bold;">
					<td>TICKET NUMBER</td>
					<td>FLIGHT NUMBER</td>
					<td>AIRLINES</td>
					<td>DEPARTURE AIRPORT</td>
					<td>DEPARTURE DATE</td>
					<td>DEPARTURE TIME</td>
					<td>ARRIVAL AIRPORT</td>
					<td>ARRIVAL DATE</td>
					<td>ARRIVAL TIME</td>
					<td>RESERVATION NUMBER</td>
					<td>MEAL PLAN</td>
					<td>CLASS TYPE</td>
					<td>OPTION</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${pastReservations}" var="reserve">
					<tr>
						<td align="left">${reserve.ticket_number}</td>
						<td align="left">${reserve.flightNumber}</td>
						<td align="left">${reserve.airline_name}</td>
						<td align="left">${reserve.depart_airport_name}</td>
						<td align="left">${reserve.depart_date}</td>
						<td align="left">${reserve.depart_time}</td>
						<td align="left">${reserve.arrival_airport_name}</td>
						<td align="left">${reserve.arrive_date}</td>
						<td align="left">${reserve.arrive_time}</td>
						<td align="left">${reserve.reservation_number}</td>
						<td align="left">${reserve.meal_plan}</td>
						<td align="left">${reserve.classType}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>

	<div class="cardView">
	
	<h1>Waitlisted Reservations for ${username}</h1>
	
		<table>
			<thead>
				<tr style="font-weight:bold;">
					<td>WAITLIST NUMBER</td>
					<td>FLIGHT NUMBER</td>
					<td>AIRLINES</td>
					<td>DEPARTURE AIRPORT</td>
					<td>ARRIVAL AIRPORT</td>
					<td>MEAL PLAN</td>
					<td>NO. OF TRAVELERS</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${waitlist}" var="wait">
					<tr>
						<td align="left">${wait.waitlist_number}</td>
						<td align="left">${wait.flightNumber}</td>
						<td align="left">${wait.airline_name}</td>
						<td align="left">${wait.depart_airport_name}</td>
						<td align="left">${wait.arrival_airport_name}</td>
						<td align="left">${wait.meal_plan}</td>
						<td align="left">${wait.travelers}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>

	<form style="margin-left: 2%;" method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>
	<br>

	<form method="Post" action="dashboard.jsp">
		<!-- destroy the session before you go to dashboard -->
		<input type="submit" value="Back To Dashboard" />
	</form>

</body>
</html>