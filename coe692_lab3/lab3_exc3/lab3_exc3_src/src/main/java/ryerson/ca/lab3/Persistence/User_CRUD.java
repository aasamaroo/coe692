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


public class User_CRUD {

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
    
    public String create(UserInfo u){
        
        String s1 = "";
        
        try{
            Connection con = getCon();
            Statement stmt = con.createStatement();
            String query = "INSERT INTO USERS (firstname, lastname, email, username, password) VALUES ('"+u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getEmail()+"', '"+u.getUserName()+"', '"+u.getPassword()+"\')";
            stmt.executeUpdate(query);
            s1 = "inserted";
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return s1;
    }
    
    public static UserInfo read(String username, String password){
        UserInfo bean = null;
        
        try{
            Connection con = getCon();
            
            String userid = "";
            String chatname = "";
            ChatInfo temp = null;
            String q = "select * from USERS WHERE username LIKE \'" + username + "\'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String email = rs.getString("email");
                String uname = rs.getString("username");
                String pw = rs.getString("password");
                userid = rs.getString("userid");
                
                if(pw.equals(password)){
                    bean = new UserInfo(fname, lname, email, uname, pw, userid);
                }  
            }
            
            q = "select * from CHAT";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("userid").equals(userid))
                {
                    String chatid = rs.getString("chatid");
                    chatname = rs.getString("chatname");
                    temp = new ChatInfo(chatname);

                    String date = rs.getString("createdDate");
                    temp.setCreatedBy(userid);
                    temp.setCreatedDate(date);
                    bean.updateChats(temp);
                }
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return bean;
    }
    
    
}
