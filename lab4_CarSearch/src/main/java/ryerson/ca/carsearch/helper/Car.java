/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carsearch.helper;

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
public class Car {

    private String carid, carname, year;
    ArrayList<Manufacturer> manufacturers;
 
    public Car(){
        
    }
    
    public Car(String carid, String carname, String year, Manufacturer manufacturer){
        this.carid = carid;
        this.carname = carname;
        this.year = year;
        this.manufacturers = new ArrayList<Manufacturer>();
        this.manufacturers.add(new Manufacturer(manufacturer.getName(), manufacturer.getCountry()));
    }
    
    public String getCarID(){
        return this.carid;
    }
    
    public String getCarName(){
        return this.carname;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public ArrayList<Manufacturer> getManufacturers(){
        return this.manufacturers;
    }
    
    public void addManufacturer(ArrayList<Manufacturer> manufacturers){
        for(Manufacturer m:manufacturers){
            this.manufacturers.add(new Manufacturer(m.getName(), m.getCountry()));
        }
    }
    
}
