/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.searchcar.endpoint;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ryerson.ca.searchcar.business.*;
import ryerson.ca.searchcar.helper.*;
import ryerson.ca.searchcar.persistence.*;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("search/{query}")
public class SearchResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.ca.searchcar.endpoint.SearchResource
     * @param query
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("query")  String query) {
        //TODO return proper representation object
        SearchBusiness sb = new SearchBusiness();
        CarList cars;
        
        try{
            cars = sb.getCarsByQuery(query);
        }catch (SQLException ex){
            Logger.getLogger(SearchResource.class.getName()).log(Level.SEVERE, null, ex);
            return (ex.getMessage());
        }
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>" + cars);
        
      
        
       
        try {
           JAXBContext jaxbContext = JAXBContext.newInstance(CarList.class, Car.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(cars, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(SearchResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    /**
     * PUT method for updating or creating an instance of SearchResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(java.lang.String content) {
    }
}
