/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carsearch.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


 @XmlRootElement(name = "cars")
@XmlAccessorType (XmlAccessType.FIELD)
       public class CarsXML{
     @XmlElement(name="car")
           private ArrayList<Car> cars;
           
           
           public List<Car>getCars(){
               return cars;
               
           }
          public  CarsXML(){
               
               
           }
           public void setCar(ArrayList<Car> cs){
               cars=cs;
               
           }
           
       }
