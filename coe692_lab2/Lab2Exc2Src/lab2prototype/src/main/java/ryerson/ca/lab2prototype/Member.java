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
public class Member {
        private String email, username, password;
        private ArrayList<Chat> chatlist = new ArrayList<Chat>();
    
    
    public Member(){
        super();
    }
    
    public Member(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
        
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
        
    public void setChat(ArrayList<Chat> chats)
    {
        chatlist = chats;
    }
    
    public void createChat(String name){
        chatlist.add(new Chat(name));
    }
    
    public ArrayList<Chat> getChats(){
        return chatlist;
    }
    
}
