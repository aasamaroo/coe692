/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.rentcar.endpoint;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ryerson.ca.rentcar.business.*;
import ryerson.ca.rentcar.helper.CarRent;
import ryerson.ca.rentcar.persistence.*;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("rent")
public class RentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RentResource
     */
    public RentResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.ca.rentcar.endpoint.RentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getCarsHold")
    public String getXml() {
        
        RentBusiness rent = new RentBusiness();
        RentXML cars = rent.getHolds();
       
        JAXBContext jaxbContext;
        
        try{
            jaxbContext = JAXBContext.newInstance(RentXML.class);
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(cars, sw);
            
            return sw.toString();
        }catch(JAXBException ex){
            Logger.getLogger(RentResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }
    
    /**
     * 
     * Retrieves representation of an instance of ryerson.ca.searchcar.endpoint.SearchResource
     * 
     */
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getCarsByUser")
    public String getborrowedXml() {
        RentBusiness rent = new RentBusiness();
        RentXML cars = rent.getCarsByQuery("");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(RentXML.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(cars, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(RentResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }

    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String updateCarHold() {

        try {
            Car_Hold_CRUD.addHold("123414");
            return ("Inserted");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RentResource.class.getName()).log(Level.SEVERE, null, ex);
            return (ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(RentResource.class.getName()).log(Level.SEVERE, null, ex);
            return (ex.getMessage());
        }

    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isRented")
    public String isRented() {
        RentBusiness rent = new RentBusiness();
        RentXML car = rent.getCarsByQuery("John123");

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(CarRent.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(car, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(RentResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    /**
     * PUT method for updating or creating an instance of RentResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
