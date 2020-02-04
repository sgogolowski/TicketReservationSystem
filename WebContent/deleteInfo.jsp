<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Delete Information</title>
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
				<b>Delete a flight</b><br/>
			<form action="DeleteFlight" method="post">
				Flight Number: <input type="text" name="flightNum" maxlength=11 required/><br/>
				Are you sure?<input type="checkbox" name="confirm" value=1><br/>
				<button class="book_button" type="submit" >Delete Flight</button>
				
				
				
			</form>
			</div>
			<br/><br/>
			
			<div class="search">
			
			<b>Delete an aircraft</b><br/>
	
			<form action="DeleteAircraft" method="post">
				Aircraft Number: <input type="text" name="aircraftNum" maxlength=3 required/><br/>
				Are you sure?<input type="checkbox" name="confirm" value=1><br/>
				<button class="book_button" type="submit" >Delete Aircraft</button>
				
				
				
			</form>
			
			</div>
			<br/><br/>
			
			<div class="search">
			<b>Delete an airport</b><br/>
			
			<form action="DeleteAirport" method="post">
				Airport Name: <input type="text" name="airportName" required/><br/>
				Are you sure?<input type="checkbox" name="confirm" value=1><br/>
				<button class="book_button" type="submit" >Delete Airport</button>
				
				
				
			</form>
			</div>
		</div>

	</div>

	<!-- <script src="" async defer></script> -->
    </body>
</html>