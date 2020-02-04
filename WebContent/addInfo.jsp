<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Add Information</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./css/customer_style.css">        
    </head>
    <body>

	<div class="card">
		<div class="content">
			<h4 style="text-align: center; font-size: 35px;">
			
				<button class="book_button" onclick="window.location.href = 'customer_rep_dash.jsp';">Dashboard</button><br/>
			</h4>
			
			<div class="search">
				<b>Add a flight</b><br/>
			<form action="AddFlight" method="post">
				Airline: <input type="text" name="airline" required/>
				Departure Airport: <input type="text" name="departAirport" required/>
				Arrival Airport: <input type="text" name="arriveAirport" required/><br/>
				Departure Date: <input type="Date" name="departDate"/>
				Arrival Date: <input type="Date" name="arriveDate"/>
				Depart Time: <input type="Time" name="departTime"/>
				Arrive Time: <input type="Time" name="arriveTime"/><br/>
				First Class Price: <input type="text" name="firstPrice"/>
				Business Class Price: <input type="text" name="busPrice"/>
				Economy Class Price: <input type="text" name="econPrice"/><br/>
				First Class Seats: <input type="text" name="firstSeats"/><br/>
				Business Class Seats: <input type="text" name="busSeats"/><br/>
				Economy Class Seats: <input type="text" name="econSeats"/><br/>
				<input type="radio" name="international" value=1 required>International 
				<input type="radio" name="international" value=0>Domestic<br/>
				Aircraft Number: <input type="text" name="aircraftNum" maxlength=3 required /><br/>
				Number of Stops: <input type="text" name="stops" required /><br/>
				
				<button class="book_button" type="submit" >Add Flight</button>
				
				
				
			</form>
			
			</div>
			<br/><br/>
			
			<div class="search">
			<b>Add an aircraft</b><br/>
	
			<form action="AddAircraft" method="post">
				Aircraft Manufacturer: <input type="text" name="manu"  required/><br/>
				Aircraft Number: <input type="text" name="num" maxlength=3 required/><br/>
			
				<button class="book_button" type="submit" >Add Aircraft</button>
				
				
				
			</form>
			</div>
			<br/><br/>
			
			<div class="search">
			<b>Add an airport</b><br/>
			
			<form action="AddAirport" method="post">
				Airport Name: <input type="text" name="airportName" required/><br/>
				<button class="book_button" type="submit" >Add Airport</button>
				
				
				
			</form>
			</div>
		</div>

	</div>

	<!-- <script src="" async defer></script> -->
    </body>
</html>