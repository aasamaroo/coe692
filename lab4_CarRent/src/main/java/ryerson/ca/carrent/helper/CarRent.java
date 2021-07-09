/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carrent.helper;

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
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRent {
    
    private String carid, holdDate, username;
    
    public CarRent(String carid, String holdDate, String username){
        this.carid = carid;
        this.holdDate = holdDate;
        this.username = username;
    }
    
    public CarRent(){
        this.carid = "";
        this.holdDate = "";
        this.username = "";
    }
    
    public String getCarID() {
        return carid;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public String getUsername() {
        return username;
    }
    
}
