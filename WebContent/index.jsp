<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300i,400,900&display=swap" rel="stylesheet">
    </head>
    <body>

	<div class="card">
		<div class="content">
			<h4 style="text-align: center; font-size: 35px;">
				<b>Log-in</b>
			</h4>
			<form action="Login" method="post">
				<label style="font-size: 20px;" for="uname"><b>Username</b></label>
				<br> <input class="input" type="text"
					placeholder="Enter Username" name="username" required> <br>
				<br> <label style="font-size: 20px;" for="psw"><b>Password</b></label>
				<br> <input class="input" type="password"
					placeholder="Enter Password" name="password" required> <br>
				<br>
				<br>
				<button type="submit" class="button">Log In</button>
				<br />
				<button onclick="window.location.href = 'register.jsp';"
					class="button">Register</button>
			</form>
		</div>

	</div>

	<!-- <script src="" async defer></script> -->
    </body>
</html>