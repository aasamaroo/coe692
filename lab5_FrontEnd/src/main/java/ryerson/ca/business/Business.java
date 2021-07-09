/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
 
import ryerson.ca.helper.*;

/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String passwrod) {
        return true;
    }

    public static CarList getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        String searchService= System.getenv("searchService");
        String holdService = System.getenv("holdService");
        WebTarget searchwebTarget
                = searchclient.target("http://"+searchService+"/SearchCar/webresources/search");
        InputStream is
                = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        CarList cars = carListtoObjects(xml);
        
        if (token != null) {
            Client holdclient = ClientBuilder.newClient();
            WebTarget holdwebTarget
                    = holdclient.target("http://"+holdService+"/HoldCar/webresources/hold/isOnHold");
            if(cars!=null){
            for (Car car : cars.getCarList()) {

                InputStream holddata
                        = holdwebTarget.path(car.getId()).queryParam("token", token).
                                request(MediaType.APPLICATION_XML).get(InputStream.class);
                try{
                    Car a=carholdxmltoObjects(IOUtils.toString(holddata, "utf-8"));
                    if(a!=null)
                        car.setTobeHold(false);
                    else
                        car.setTobeHold(true);
                }
                catch(Exception e){
                    car.setTobeHold(false);
                }
                
                
            }
            }
        }
        

        return (cars);

    }

    private static CarList carListtoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CarList.class, Car.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            CarList cars = (CarList) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return cars;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static Car carholdxmltoObjects(String xml) {
        if(xml.isEmpty())
            return null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Car.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Car car = (Car) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return car;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

   

}
