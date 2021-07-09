/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carsearch.business;


import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import ryerson.ca.carsearch.helper.*;
import ryerson.ca.carsearch.persistence.*;

/**
 *
 * @author student
 */
public class CarSearchBusiness {
    
    public  CarsXML getCarsByQuery(String query){
       Set<Car> cars = Car_CRUD.searchForCars(query);
       Map<String ,Car> allManufacturersCars= new HashMap ();
           System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+ cars.size());
        for(Car car : cars){
            if(allManufacturersCars.containsKey(car.getCarID())){
                allManufacturersCars.get(car.getCarID()).addManufacturer(car.getManufacturers());
            }
            else{
               
                allManufacturersCars.put(car.getCarID(),car );
            }
        }
        System.out.println("**********************"+ allManufacturersCars.size());
        CarsXML cs;
        cs = new CarsXML();
        cs.setCar(new ArrayList(allManufacturersCars.values()));
        return (cs);
    }
    
      
}
