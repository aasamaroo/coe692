/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.rentcar.helper;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
 *
 * @author student
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRent {
    
    
    private String carid, rentDate, username;
    
    
    public CarRent(){
        this.carid = null;
        this.rentDate = null;
        this.username = null;
    }
    
    public CarRent(String carid, String rentDate, String username){
        this.carid = carid;
        this.rentDate = rentDate;
        this.username = username;
    }
    
    public String getCarId(){
        return carid;
    }
    
    public String getRentDate(){
        return rentDate;
    }
    
    public String getUsername(){
        return username;
    }
}
