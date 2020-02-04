<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Information</title>
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
				<b>Edit a flight</b><br/>
			<form action="showFlight.jsp" method="post">
				Flight Number: <input type="text" name="flightNum" maxlength=11 required/><br/>
				<button class="book_button" type="submit" >Edit Flight</button>
			
				
			</form>
			</div>
			<br/><br/>
			
			<div class="search">
			<b>Edit an aircraft</b><br/>
	
			<form action="showAircraft.jsp" method="post">
				Aircraft Number: <input type="text" name="num" maxlength=3 required/><br/>
				<button class="book_button" type="submit" >Edit Aircraft</button>
				
				
				
			</form>
			</div>
			<br/><br/>
			
			<div class="search">
			<b>Edit an airport</b><br/>
			
			<form action="showAirport.jsp" method="post">
				Airport ID: <input type="text" name="airportID" required/><br/>
				<button class="book_button" type="submit" >Edit Airport</button>
				
				
				
			</form>
			</div>
		</div>

	</div>

	<!-- <script src="" async defer></script> -->
    </body>
</html>