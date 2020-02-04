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
                <h4 style="text-align: center; font-size: 35px;"><b>Register</b></h4>
                <form action="Register" method="post">
                
                    <label style="font-size: 20px;" for="setUsername"><b>Set Username</b></label>
                    <br>
                  <input class="input" type="text" placeholder="Set Username" name="setUsername" required>
                  <br><br>
                  
                  <label  style="font-size: 20px;" for="setPassword"><b>Set Password</b></label>
                  <br>
                  <input class="input" type="password" placeholder="Set Password" name="setPassword" required>
                  <br><br>
                  
                  <label style="font-size: 20px;" for="confirmPassword"><b>Confirm Password</b></label>
                    <br>
                  <input class="input" type="password" placeholder="Confirm Password" name="confirmPassword" required>
                  <br><br>
                  
                  <label style="font-size: 20px;" for="First Name"><b>First Name</b></label>
                    <br>
                  <input class="input" type="text" placeholder="First Name" name="firstName" required>
                  <br><br>
                  
                  <label style="font-size: 20px;" for="Last Name"><b>Last Name</b></label>
                    <br>
                  <input class="input" type="text" placeholder="Last Name" name="lastName" required>
                  <br><br>
                  
                  <input type="radio" name="account" value="customer"> Customer
                  <input type="radio" name="account" value="customer_rep"> Customer Rep
                  <input type="radio" name="account" value="Admin"> Admin
                  
                  <button type="submit" class="button">Register</button> <br/>
                </form>
            </div>
              
          </div>
        
        <!-- <script src="" async defer></script> -->
    </body>
</html>