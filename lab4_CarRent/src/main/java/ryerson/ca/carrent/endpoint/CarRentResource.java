/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carrent.endpoint;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ryerson.ca.carrent.business.*;
import ryerson.ca.carrent.helper.*;

/**
 *
 * @author student
 */
@Path("rent")
public class CarRentResource {
   
    @Context
    private UriInfo context;
    
    public CarRentResource(){
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isRented/{carid}")
    public String getXml(@PathParam("carid") String carid){
        System.out.println(carid);
        CarRentBusiness rent = new CarRentBusiness();
        CarRent car = rent.getCars(carid);
        if (car == null) {
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CarRent.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(car, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(CarRentResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String updateCarRent(@FormParam("carid") String carid, @FormParam("userid") String userid){
        CarRentBusiness rent = new CarRentBusiness();
        boolean cs = rent.rent(carid, userid);
        if(cs){
            return("inserted");
        }else{
            return("not inserted");
        }
    }
}
