/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.searchcar.helper;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author student
 */
@XmlRootElement(name="lists")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarList {
    
    Set<Car> carslist;
    
    public CarList(){
        
    }
    
    @XmlElement(type=Car.class)
    public Set<Car> getCarList(){
        return carslist;
    }
    
    public void setCarList(Set<Car> carslist){
        this.carslist = carslist;
    }
}
