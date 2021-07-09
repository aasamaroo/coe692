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
    public static boolean isAuthenticated(String username, String password){
        return true;
    }
    
    public static CarsXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        WebTarget searchwebTarget
                = searchclient.target("http://localhost:8080/CarSearch/webresources/search");
        InputStream is
                = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        CarsXML cars = carxmltoObjects(xml);
        if (token != null) {
            Client rentclient = ClientBuilder.newClient();
            WebTarget rentwebTarget
                    = rentclient.target("http://localhost:8080/CarRent/webresources/rent/isRented");
            for (Car car : cars.getCars()) {

                InputStream rentdata
                        = rentwebTarget.path(car.getCarID()).queryParam("token", token).
                                request(MediaType.APPLICATION_XML).get(InputStream.class);
                try{
                    Car a=carrentxmltoObjects(IOUtils.toString(rentdata, "utf-8"));
                    if(a!=null)
                        car.setToBeRented(true);
                    else
                        car.setToBeRented(false);
                }
                catch(Exception e){
                    car.setToBeRented(false);
                }
                
                
            }
        }

        return (cars);

    }

    private static CarsXML carxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CarsXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            CarsXML cars = (CarsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return cars;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Car carrentxmltoObjects(String xml) {
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
