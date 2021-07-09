/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab3.Helper;

/**
 *
 * @author student
 */

import java.util.*;

public class UserInfo {
    private String firstname, lastname, email, username, password, userid;
    private ArrayList<ChatInfo> chats = new ArrayList<ChatInfo>();
    
    
    public UserInfo(){
        super();
    }
    
    public UserInfo(String firstname, String lastname, String email, String username, String password, String userid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userid = userid;
        
    }
    
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public void setLastName(String lastname){
        this.lastname = lastname;
    }
    
    public String getLastName(){
        return lastname;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setUserName(String username){
        this.username = username;
    }
    
    public String getUserName(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUserID(String userid){
        this.userid = userid;
    }
    
    public String getUserID(){
        return userid;
    }
    
    public void setChats(ArrayList<ChatInfo> chats)
    {
        this.chats = chats;
    }
    
    public ArrayList<ChatInfo> getChats(){
        return chats;
    }
    
    public void updateChats(ChatInfo c){
        chats.add(c);
    }
}
