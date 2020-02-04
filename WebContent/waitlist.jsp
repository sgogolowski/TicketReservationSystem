<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/customer_style.css">
<title>Insert title here</title>
</head>
<body>

<div class="search">
	<h3>Oo-Oh. Atleast one flight that you selected is full. Do you wait to get waitlisted?</h3>

	
	<br>

	<form method="Post" action="MakeWaitlist">
		<input type="radio" name="response" value="yes">Yes<br> <input
			type="radio" name="response" value="no">No<br><br> <input
			type="submit" value="submit"> 
	</form><br><br>
	
	<form method="Get" action="Logout">
		<input type="submit" value="Logout" />
	</form>
	</div>
</body>
</html>