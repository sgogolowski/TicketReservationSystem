<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Admin Dashboard</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/admin_style.css">        
        
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
            <h1 style="float: left; margin-left: 20px;">Admin Page - <i><small>${username}</small></i></h1>
            <div class="topnav-right">
                <img src="./img/user.png" style="width: 70px; height: 70px; padding: 10px; margin: 10px;">
            </div>
          </div>
	<div class="row">
	
	<div class="column side" >
		<div class="sticky">
			<a href="#person_list">Generate Person List </a><br>
			<a href="#sales_report">Sales Report of a particular Month</a><br>
			<a href="#search_reservation">Search reservation</a><br>
			<a href="#search_summary">Produce summary list</a><br>
			<a href="#search_rich">Search Richest Customer</a><br>
			<a href="#search_active">Search most active flight</a><br>
			<a href="#search_airport_flight">Search Flights by Airport</a>
		</div>
	</div>
	<div class="column middle">
	
	<section id="person_list">
		<div class="search">
				<form action="SearchPerson" method="post">
					
					<sub>Generate Person List</sub>
					
					<input
						type="submit" value="Generate"> 

				</form>
			</div>
	
		</br> 
		</br> 
		<div class="result_card">
					<table>
						<thead>
							<tr>
								<td><b>Username</b></td>
								<td><b>Password</b></td>
								<td><b>fname</b></td>
								<td><b>lname</b></td>
								<td><b>email</b></td>
								<td><b>isCustomerRep</b></td>
								<td><b>isAdmin</b></td>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${personList}" var="person">
								<tr>
									<td align="left">${person.username}</td>
									<td align="left">${person.password}</td>
									<td align="left">${person.fname}</td>
									<td align="left">${person.lname}</td>
									<td align="left">${person.email}</td>
									<td align="left">${person.isCustomerRep}</td>
									<td align="left">${person.isAdmin}</td>
									
									<td><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

			</div>
		</br> 
		</br> 
			<div class="search">
				<form action="EditCustomer" method="post">
					<sub> Add, Edit or Delete</sub>
					<select name = "EditOption" class = "choose">
						<option value = "Add" selected>
						Add
						</option>
						<option value = "Edit" >
						Edit
						</option>
						<option value = "Delete" >
						Delete
						</option>
					</select>
						<input 
						type="text" name="personUsername" placeholder="username" id required>
						<input 
						type="text" name="personPassword" placeholder="password">
						<input 
						type="text" name="personFname" placeholder="First Name">
						<input 
						type="text" name="personLname" placeholder="Last Name">
						<input 
						type="text" name="personEmail" placeholder="Email">
						<input 
						type="text" name="personIsCustomerRep" placeholder="isCustomerRep" required>
						<input 
						type="text" name="personIsAdmin" placeholder="isAdmin" required>
					
					<input
						type="submit" value="submit"> 
						</br>

				</form>
			</div>
	</section>

		</br> 
		</br> 
	<section id="sales_report">
			<div class="search">
				<form action="SearchTickets" method="post">
					<sub> Sales Report of a particular Month</sub>
					<input 
						type="text" name="saleReport" placeholder="YYYY-MM">
					
					<input
						type="submit" value="submit"> 
						</br>

				</form>
			</div>

			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td ><b>ticket_number</b></td>
								<td ><b>username</b></td>
								<td >issue_date</td>
								<td ><b>price</b></td>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${ticketList}" var="ticket">
								<tr>
									<td align="left">${ticket.ticket_number}</td>
									<td align="left">${ticket.username}</td>
									<td align="left">${ticket.issue_date}</td>
									<td align="left">${ticket.price}</td>
									<td><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

			</div>
	</section>
		</br> 
		</br> 
		
	<section id="search_reservation">
		<div class="search">
			<sub>Search reservation by Flight Number or Customer Username</sub>
				
				<form action="SearchReservation" method="post">
				
				<select name = "ListReservation" class = "choose">
						<option value = "flightNumber" selected>
						Flight Number
						</option>
						<option value = "customerUsername" >
						Customer Username
						</option>
				</select>
					
					<input 
						type="text" name="searchRes" placeholder="name" required>
					
					<input
						type="submit" value="submit"> 
						
						

				</form>
			</div>
			
			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td width="7%"><b>ticket_number</b></td>
								<td width="7%"><b>flightNumber</b></td>
								<td width="7%"><b>airline_name</b></td>
								<td width="7%"><b>depart_time</b></td>
								<td width="7%"><b>depart_date</b></td>
								<td width="7%"><b>depart_airport_name</b></td>
								<td width="7%"><b>arrive_time</b></td>
								<td width="7%"><b>arrive_day</b></td>
								<td width="7%"><b>arrival_airport_name</b></td>
								<td width="7%"><b>meal_plan</b></td>
								<td width="7%"><b>reservation_number</b></td>
								<td width="7%"><b>seat_number</b></td>
								<td width="7%">classType</td>
						
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${reservationList}" var="reservation">
								<tr>
									<td align="left" width="7%">${reservation.ticket_number}</td>
									<td align="left" width="7%">${reservation.flightNumber}</td>
									<td align="left" width="7%">${reservation.airline_name}</td>
									<td align="left" width="7%">${reservation.depart_time}</td>
									<td align="left" width="7%">${reservation.depart_date}</td>
									<td align="left" width="7%">${reservation.depart_airport_name}</td>
									<td align="left" width="7%">${reservation.arrive_time}</td>
									<td align="left" width="7%">${reservation.arrive_day}</td>
									<td align="left" width="7%">${reservation.arrival_airport_name}</td>
									<td align="left" width="7%">${reservation.meal_plan}</td>
									<td align="left" width="7%">${reservation.reservation_number}</td>
									<td align="left" width="7%">${reservation.seat_number}</td>
									<td align="left" width="7%">${reservation.classType}</td>
									
									<td width="7%"><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</section>
					
		</br> 
		</br> 
		
		<section id="search_summary">
			<div class="search">
			<sub>Produce summary list</sub>
				<form action="SearchSummary" method="post">
				
					<select name = "summaryListOption" class = "choose">
						<option value = "flightNo" selected>
						Flight Number
						</option>
						<option value = "airlineNo" >
						Airline
						</option>
						<option value = "customerNa" >
						Customer Name
						</option>
					</select>
					</br> 
					
					<input 
						type="text" name="summaryInput" placeholder="">
					
					<input
						type="submit" value="submit"> 
						
						</br>

				</form>
			</div>
			
			
			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td ><b>username</b></td>
								<td ><b>FLIGHT NUMBER</b></td>
								<td ><b>AIRLINES</b></td>
								<td ><b>CLASSTYPE</b></td>
								<td ><b>Economy_price</b></td>
								<td ><b>Business_price</b></td>
								<td ><b>First_class_price</b></td>
								<td ><b>Total Pay</b></td>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${summaryList}" var="summary">
								<tr>
									<td align="left">${summary.username}</td>
									<td align="left">${summary.flightNumber}</td>
									<td align="left">${summary.airline_name}</td>
									<td align="left">${summary.classType}</td>
									<td align="left">${summary.economy_price}</td>
									<td align="left">${summary.business_price}</td>
									<td align="left">${summary.first_class_price}</td>
									
									<td align="left"><input type="text" name="actualPay" id = "actualPay"
										/></td>
									<td>
										</td>
									<td><a href="${pageContext.request.contextPath}"></a></td>
									
								</tr>
								<script type = "text/javascript">
											if(document.getElementById('SclassType').value == "economy"){
												document.getElementById('actualPay').value = document.getElementById('Seconomy_price').value;
											}else if(document.getElementById('SclassType').value == "business"){
												document.getElementById('actualPay').value = document.getElementById('Sbusiness_price').value;
											}else{
												document.getElementById('actualPay').value = document.getElementById('Sfirst_class_price').value;
											}
										</script>
							</c:forEach>
						</tbody>
					</table>

			</div>
			
		</section>
			
		<section id="search_rich">
						
			<div class="search">
			<sub>Search Richest Customer</sub>
				<form action="SearchRichestCustomer" method="post">
					</br> 
					
					<input
						type="submit" value="Generate"> 
						
						</br>

				</form>
			</div>
			
			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td ><b>username</b></td>
								<td ><b>price</b></td>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${richList}" var="rich">
								<tr>
									<td align="left">${rich.username}</td>
									<td align="left">${rich.price}</td>
									<td><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

			</div>
			
		</section>
		
		<section id="search_active">
		
			<div class="search">
			<sub>Search most active flight</sub>
				<form action="SearchActiveFlight" method="post">
					</br> 
					
				
					<input
						type="submit" value="Generate"> 
						
						</br>

				</form>
			</div>
			
			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td ><b>Flight Number</b></td>
								<td ><b>Airline</b></td>
								<td ><b>Total Sold Amount</b></td>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${activeFlightList}" var="activeFlight">
								<tr>
									<td align="left">${activeFlight.flightNumber}</td>
									<td align="left">${activeFlight.airline_name}</td>
									<td align="left">${activeFlight.totalSold}</td>
									<td><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

			</div>
			
		</section>
		
		<section id="search_airport_flight">	
			
			<div class="search">
			<sub>Search Flights by Airport</sub>
				<form action="SearchAirportFlights" method="post">
					</br> 
					
					<input 
						type="text" name="airportName" placeholder="airport">
					
					<input
						type="submit" value="submit"> 
						
						</br>

				</form>
			</div>
			
			<div class="result_card">
					<table>
						<thead>
							<tr>
								<td ><b>FLIGHT NUMBER</b></td>
								<td ><b>AIRLINES</b></td>
								<td ><b>DEPARTURE TIME</b></td>
								<td ><b>ARRIVAL TIME</b></td>
								<td ><b>DEPARTURE DATE</b></td>
								<td ><b>ARRIVAL DATE</b></td>
								<td ><b>DEPARTURE AIRPORT</b></td>
								<td ><b>ARRIVAL AIRPORT</b></td>
								
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${airportFlightList}" var="airportFlight">
								<tr>
									<td align="left">${airportFlight.flightNumber}</td>
									<td align="left">${airportFlight.airline_name}</td>
									<td align="left">${airportFlight.departTime}</td>
									<td align="left">${airportFlight.arriveTime}</td>
									<td align="left">${airportFlight.depart_date}</td>
									<td align="left">${airportFlight.arrive_date}</td>
									<td align="left">${airportFlight.depart_airport_name}</td>
									<td align="left">${airportFlight.arrival_airport_name}</td>
									<td><a href="${pageContext.request.contextPath}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

			</div>
			
		</section>	
		<div>	
			<div>
		
			<form method="Get" action="Logout">
				<input type="submit" value="Logout" />
			</form>
			
			</div>	

		</div>
		
	</div>
	


	

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>
