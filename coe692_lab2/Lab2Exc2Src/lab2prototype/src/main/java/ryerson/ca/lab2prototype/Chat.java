/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2prototype;

import java.util.*;
/**
 *
 * @author student
 */
public class Chat {
    
    private String chatName;
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<Member> members = new ArrayList<Member>();
    
    public Chat(String chatName){
        this.chatName = chatName;
    }
    
    public void addUser(Member m){
        members.add(m);
    }
    
    public void sendMessage(String message){
        messages.add(message);
    }
    
    public String getChatName(){
        return chatName;
    }
}

