/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.searchcar.business;

import java.sql.*;
import java.util.*;
import ryerson.ca.searchcar.helper.*;
import ryerson.ca.searchcar.persistence.*;
/**
 *
 * @author student
 */
public class SearchBusiness {
    
    
    public SearchBusiness(){
        
    }
    
    public CarList getCarsByQuery(String query) throws SQLException{
        
        Set<Car> cars = Car_CRUD.searchForCars(query);
        CarList newList = new CarList();
        newList.setCarList(cars);
        return newList;
    }
}
