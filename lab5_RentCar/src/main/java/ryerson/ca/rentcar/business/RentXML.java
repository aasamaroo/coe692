/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.rentcar.business;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import ryerson.ca.rentcar.helper.CarRent;


 @XmlRootElement
       public class RentXML{
           private ArrayList<CarRent> cars;
           @XmlElementWrapper
           @XmlElement(name="carRented")
           public List<CarRent>getCars(){
               return cars;
               
           }
           public RentXML(){
               
               
           }
           public void setCar(ArrayList<CarRent> rs){
               cars=rs;
               
           }
           
       }
