<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Customer Representative Dashboard</title>
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
            <h1 style="float: left; margin-left: 20px;">Travel Website - <i><small>Customer Representative</small></i></h1>
            <div class="topnav-right">
                <img src="./img/user.png" style="width: 70px; height: 70px; padding: 10px; margin: 10px;">
            </div>
          </div>
          <div class="search">
			
            <button class="book_button" onclick="window.location.href = 'makeCustReserv.jsp';">Make Customer Reservation</button><br/>
            <form action="showReservation.jsp">
			Reservation Number: <input type="text" name="resNum" required/>
			<button class="book_button" onclick="window.location.href = 'editCustReserv.jsp';">Edit Customer Reservation</button>
			</form>
			
			<form action="custRepWaitlist.jsp">
			Flight Number: <input type="text" name="flightNumber" required/>
			<button class="book_button" type="submit">Flight Waiting List</button><br/><br/>
			</form>
			
			<button class="book_button" onclick="window.location.href = 'addInfo.jsp';">Add Information</button>
			<button class="book_button" onclick="window.location.href = 'editInfo.jsp';">Edit Information</button>
			<button class="book_button" onclick="window.location.href = 'deleteInfo.jsp';">Delete Information</button><br/><br/>
			
            </div>

	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>

	<script src="./js/customer_dash_script.js" async defer></script>
        
    </body>
</html>
