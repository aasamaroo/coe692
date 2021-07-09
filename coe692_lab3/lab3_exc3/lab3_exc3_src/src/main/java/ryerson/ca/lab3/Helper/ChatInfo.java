/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab3.Helper;

import java.util.*;
/**
 *
 * @author student
 */
public class ChatInfo {
    
    private String chatName;
    private String createdBy;
    private String createdDate;
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<UserInfo> members = new ArrayList<UserInfo>();
    
    public ChatInfo(String chatName){
        this.chatName = chatName;
    }
    
    public void addUser(UserInfo u){
        members.add(u);
    }
    
    public void setCreatedBy(String c)
    {
        this.createdBy = c;
    }
    
    public void setCreatedDate(String c)
    {
        this.createdDate = c;
    }
    
    public void sendMessage(String message){
        messages.add(message);
    }
    
    public String getChatName(){
        return chatName;
    }
}
