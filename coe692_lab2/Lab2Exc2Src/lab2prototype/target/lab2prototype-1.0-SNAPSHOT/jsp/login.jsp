<%-- 
    Document   : login
    Created on : Feb 18, 2021, 3:18:43 PM
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
    
    <body background="jspresources\Background.jpg">
    
    <center><h1>Login to Your Chat App Account</h1></center>
    
    
    <body>
    
        <form method="get" action="http://localhost:8080/lab2prototype/Login">
            
            <pre>
            <center>
        
       Email:    <input type="text" name="email" placeholder="Please Enter Your Email">
        
       Password: <input type="password" name="password" placeholder="Please Enter Your Password">
        
        <input type="submit" value="Login">
        

            </center>
            </pre>
        
        </form>
    
    </body>
</html>
