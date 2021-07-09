/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.holdcar.endpoint;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;

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
import ryerson.ca.holdcar.business.*;
import ryerson.ca.holdcar.helper.*;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("hold")
public class HoldResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HoldResource
     */
    public HoldResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.ca.holdcar.endpoint.HoldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("carid") String carid) {
        //TODO return proper representation object
        HoldBusiness hold = new HoldBusiness();
        CarHold car = hold.getCar(carid);
        if(car == null){
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CarHold.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(car, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(HoldResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String updateCarHold(@FormParam("carid") String carid, @FormParam("userid") String userid) throws InterruptedException, ServerAddressNotSuppliedException{
        HoldBusiness hold = new HoldBusiness();
        boolean cs;
        try{
            try {
                cs = hold.hold(carid, userid);
            } catch (ServerAddressNotSuppliedException ex) {
                Logger.getLogger(HoldResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            return("Inserted");
        }catch(ClassNotFoundException | SQLException | IOException ex){
            Logger.getLogger(HoldResource.class.getName()).log(Level.SEVERE, null, ex);
            return (ex.getMessage());
        }
        
    }
}
       
        
    

   

