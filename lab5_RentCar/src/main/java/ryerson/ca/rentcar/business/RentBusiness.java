/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.rentcar.business;

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
import org.apache.commons.codec.binary.Base64;
import ryerson.ca.rentcar.helper.CarRent;
import ryerson.ca.rentcar.persistence.*;



/**
 *
 * @author student
 */
public class RentBusiness {

    
    public RentBusiness(){
        
    }
    public  RentXML getCarsByQuery(String username){
       Set<CarRent> cars = User_Car_Rent_CRUD.getRentedCars(username);
       
       
        RentXML rs;
        rs = new RentXML();
        rs.setCar(new ArrayList(cars));
        return (rs);
    }
    
    
    
    public  RentXML getHolds(){
        Set<CarRent> holds = Car_Hold_CRUD.getHolds();
       
       RentXML rs;
        rs = new RentXML();
        rs.setCar(new ArrayList(holds));
        return (rs);
    }
  
}