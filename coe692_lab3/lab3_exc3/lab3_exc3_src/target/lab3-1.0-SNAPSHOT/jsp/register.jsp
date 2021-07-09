<%-- 
    Document   : register
    Created on : Mar 6, 2021, 9:26:12 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <title>
        Register
    </title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body background ="jspresources\Background.jpg">
        
    <center><h1>Register</h1></center>
    
    <body>
        <form method="post" action="/lab3/Register"> 
            
        <pre>
        <center>
                
        First Name:  <input type="text" name="firstname" placeholder="First Name">
        Last Name:   <input type="text" name="lastname" placeholder="Last Name">
        Email:       <input type="text" name="email" placeholder="Email">
        Username:    <input type="text" name="username" placeholder="Username">
        Password:    <input type="text" name="password" placeholder="Password">
        
        <input type="submit" value="Register">
        
        <a href="login.jsp">Already have an account? Click here to login.</a>
        
        </center>
        </pre>
        </form>    
    </body>
</html>
