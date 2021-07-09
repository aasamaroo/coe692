package ryerson.ca.holdcar.business;


import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ryerson.ca.holdcar.helper.*;
import ryerson.ca.holdcar.persistence.*;
/**
 *
 * @author student
 */
public class HoldBusiness {
    
    public HoldBusiness(){
        
    }
    
    public CarHold getCar(String carID){
        
        CarHold cs = Car_Hold_CRUD.getHoldCar(carID);
        return cs;
    }
    
    public boolean hold(String carID, String username) throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException{
        boolean success = false;
        
        success = Car_Hold_CRUD.addHold(carID, username);
        if(success){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.now();
            
            LocalDate exDate = date.plusDays(3);
            
            Messaging.sendmessage("HOLD: "+carID+":"+username+":"+exDate.format(formatter));
        }
        return success;
    }
}
