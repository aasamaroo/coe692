<%-- 
    Document   : welcome
    Created on : Mar 6, 2021, 9:26:22 PM
    Author     : student
--%>

<%@page import="ryerson.ca.lab3.Helper.UserInfo"%>
<%@page import="ryerson.ca.lab3.Helper.ChatInfo"%>
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
        ArrayList<ChatInfo> chats = (ArrayList)request.getSession().getAttribute("chats");
        %>
        
    <center><h2>Welcome <%=session.getAttribute("username")%></h2></center>
    <br>
    <center><h3>Your Chats</h3></center>
    <br>
    
    <center>
    <form action="AddChat" method="post">
        <table border="2" allign="center" cellpadding="5" cellspacing="5">
            <tr>
                <th>chats: </th>
                </tr>
                
                <% for(ChatInfo chat : chats){%>
                
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
