/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.helper;

import javax.xml.bind.annotation.*;

/**
 *
 * @author student
 */
@XmlRootElement(name="car")
public class Car {
    
    private String id, year;
    private String manufacturer, model;
    private boolean tobeHold;
    
    public boolean isTobeHold(){
        return tobeHold;
    }
    
    public Car(){
        
    }
    
    public void setTobeHold(boolean tobeHold) {
        this.tobeHold = tobeHold;
    }
    
    public Car(String id, String year, String manufacturer, String model){
        this.id = id;
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
            this.id = id;
    }
    
    public String getYear(){
        return year;
    }
    
    public void setYear(String year){
        this.year = year;
    }
    
    public String getManufacturer(){
        return manufacturer;
    }
    
    public void setManufacturer(String manu){
        manufacturer = manu;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String model){
        this.model = model;
    }
}
