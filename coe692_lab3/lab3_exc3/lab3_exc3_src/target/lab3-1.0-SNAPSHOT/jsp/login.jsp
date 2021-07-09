<%-- 
    Document   : login
    Created on : Mar 6, 2021, 9:26:02 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <title>
        Login
    </title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body background="jspresources\Background.jpg">
    
    <center><h1>Login to Your Chat App Account</h1></center>
    
    
    <body>
        <form method="post" action="/lab3/Login">
            
        <pre>
        <center>
        
        Username: <input type="text"     name="username" placeholder="Please Enter Your Username">
        Password: <input type="password" name="password" placeholder="Please Enter Your Password">
        
        <input type="submit" value="Login">
        
        <a href="register.jsp">Don't have an account? Click here to register.</a>
       
        </center>
        </pre>
        </form>
    </body>
</html>
