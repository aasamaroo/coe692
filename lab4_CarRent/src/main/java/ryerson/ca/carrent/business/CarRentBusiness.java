/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carrent.business;

import ryerson.ca.carrent.helper.*;
import ryerson.ca.carrent.persistence.*;
/**
 *
 * @author student
 */
public class CarRentBusiness {
    
    public CarRent getCars(String carid) {
        CarRent cs = Car_Rent_CRUD.getCarRent(carid);

        return (cs);
    }

public boolean rent(String carid, String userid) {
       
        return (Car_Rent_CRUD.addRent(carid, userid));
    }
}
