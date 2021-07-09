/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carsearch.helper;

/**
 *
 * @author student
 */
public class Manufacturer {
    String manuname;
    String country;
    
    public String getName(){
        return manuname;
    }
    
    public String getCountry(){
        return country;
    }
    
    public Manufacturer(String name, String country){
        this.manuname = name;
        this.country = country;
    }
}
