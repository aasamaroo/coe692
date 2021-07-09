<%-- 
    Document   : welcome
    Created on : Feb 18, 2021, 3:18:52 PM
    Author     : student
--%>
<%@page import="ryerson.ca.lab2prototype.Member"%>
<%@page import="ryerson.ca.lab2prototype.Chat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat App</title>
    </head>
    
    <body background="jsprecourses/Background.jpg">
        
    <body>
        <%    
        ArrayList<Chat> chatlist = (ArrayList)request.getSession().getAttribute("listOfChats");
        %>
        
    <center><h2>Welcome <%=session.getAttribute("email")%></h2></center>
    <br>
    <center><h3>Your Chats</h3></center>
    <br>
    
    <center>
    <form action="AddChat" method="get">
        <table border="2" allign="center" cellpadding="5" cellspacing="5">
            <tr>
                <th>Chats: </th>
                </tr>
                
                <% for(Chat chat : chatlist){%>
                
                <tr>
                    <td><%=chat.getChatName()%></td>
                    <td><input type="submit" value="Join Room"></td>
                    
                <%}%>

</tr>
</table>
</form>
</center>

<center>
<form action="AddChat" method ="post">
    Create a new chat:
    <input type="text" name="chatName" placeholder="New Chat Name">
    <input type="submit" value="Add">
    </form>
    </center>
                
                
            
            
            
    </body>
</html>
