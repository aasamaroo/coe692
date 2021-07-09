/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.holdcar.helper;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author student
 */
@XmlRootElement(name="car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarHold {
    
    private String carid, holdDate, username;
    
    public CarHold(){
        
    }
    
    public CarHold(String carID, String holdDate, String username){
        this.carid = carID;
        this.holdDate = holdDate;
        this.username = username;
    }
    
    public String getCarID(){
        return carid;
    }
    
    public String getHoldDate(){
        return holdDate;
    }
    
    public String getUsername(){
        return username;
    }
}
