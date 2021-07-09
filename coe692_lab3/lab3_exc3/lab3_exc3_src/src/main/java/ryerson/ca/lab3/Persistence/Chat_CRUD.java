/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab3.Persistence;

/**
 *
 * @author student
 */
import ryerson.ca.lab3.Helper.*;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;

public class Chat_CRUD {
    
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CHAT?autoReconnect=true&useSSL=false","root","student");
            System.out.println("Connection established.");
	}catch(Exception e){System.out.println(e);
        }
        return con;
    }
    
    public String create(String chatName, UserInfo u){
        String s1 = "";
        String chatid = "";
        String userid = "";
        LocalDate date = LocalDate.now();
            
            try{
                Connection con = getCon();
                Statement stmt = con.createStatement();
                String query = "INSERT INTO CHAT (chatname, createdDate, userid) VALUES ('"+chatName+"', " + "'" + date + "', " + u.getUserID() + ")";
                stmt.executeUpdate(query);

                s1 = "inserted";
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
           
        return s1;
    }
    
    public static ChatInfo read(String chatname){
        ChatInfo temp = null;
        String chatid = "";
        String userid = "";
        String date = "";
        try{
            Connection con = getCon();
            
            String q = "select chatid, userid, createdDate from CHAT WHERE chatname LIKE \'" + chatname + "\'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                chatid = rs.getString("chatid");                
                temp = new ChatInfo(chatname);
                userid = rs.getString("userid");
                date = rs.getString("createdDate");
                
                temp.setCreatedBy(userid);
                temp.setCreatedDate(date);
            }
          
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return temp;
    }
}
