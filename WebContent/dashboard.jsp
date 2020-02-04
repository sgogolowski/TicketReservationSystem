<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Dashboard</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/customer_style.css">
    </head>
    <body>
    
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");
	    
		if(session.getAttribute("username")==null)
			response.sendRedirect("index.jsp");
	%>
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class="topnav">
            <h1 style="float: left; margin-left: 20px;">Travel Website - <i><small>${username}</small></i></h1>
            <div class="topnav-right">
                <img src="./img/user.png" style="width: 70px; height: 70px; padding: 10px; margin: 10px;">
            </div>
          </div>
	
	<form action="ViewReservations" method="GET">
		<input type="submit" value="View My Reservations">
	</form>

		<div class="column middle">
			<div class="search">
				<form action="SearchFlights" method="post">
					<select name="trip" class="choose">
						<option value="one-way" selected>One Way</option>
						<option value="round-trip">Round Trip</option>
					</select> <select name="class" class="choose">
						<option value="economy">Economy</option>
						<option value="business">Business</option>
						<option value="firstClass">First Class</option>
					</select> 
					<select name="numberOfSeats" class="choose">
						<option value="1">1 Traveler</option>
						<option value="2">2 Travelers</option>
						<option value="3">3 Travelers</option>
						<option value="4">4 Travelers</option>
					</select> </br>
					<input type="text" name="departAirport" placeholder="From">
					<input type="text" name="arriveAirport" placeholder="To"> <input
						type="date" name="departDate" placeholder="YYYY-MM-DD"> <input
						type="date" name="arriveDate" placeholder="YYYY-MM-DD"> </br> <input
						type="submit" value="submit"> </br>

				</form>
			</div>

			<div class="filter">
				<button class="book_button" onclick="sorttable.innerSortFunction.call(document.getElementById('sortPrice'))">sort by price</button>
				
				<button class="book_button" onclick="sorttable.innerSortFunction.call(document.getElementById(''))">sort by stops</button>
				
				<button class="book_button" onclick="sorttable.innerSortFunction.call(document.getElementById('sortAirline'))">sort by airline</button>
				
				<input style="margin-left: 2%;" type="text" id="myFilterInput" onkeyup="myFilter()" placeholder="Filter by airlines">
							
			</div>

			<div class="result_card">
					<table class="sortable">
						<thead>
							<tr>
								<td><b>FLIGHT NUMBER</b></td>
								<td id="sortAirline"><b>AIRLINES</b></td>
								<td><b>DEPARTURE TIME</b></td>
								<td><b>ARRIVAL TIME</b></td>
								<td><b>DEPARTURE DATE</b></td>
								<td><b>ARRIVAL DATE</b></td>
								<td id="sortPrice"><b>PRICE ($)</b></td>
							</tr>
						</thead>

						<tbody id="myTable">

							<c:forEach items="${list}" var="flight">
								<tr>
									<td align="left">${flight.flightNumber}</td>
									<td align="left">${flight.airline_name}</td>
									<td align="left">${flight.departTime}</td>
									<td align="left">${flight.arriveTime}</td>
									<td align="left">${flight.depart_date}</td>
									<td align="left">${flight.arrive_date}</td>
									<td align="left">${flight.price}</td>
									<td align="left"><button class="book_button" onclick="window.location.href = '${pageContext.request.contextPath}/CheckRoundTrip?flightNumber=${flight.flightNumber}&price=${flight.price}';">Select</button></td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
			</div>			

		</div>

	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
	<script src="./js/sorttable.js"></script>
        
    </body>
</html>
